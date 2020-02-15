package com.anil.myweatherapp

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import kotlin.properties.Delegates
import com.android.artgallery.di.component.DaggerApplicationComponent

/**
 * Created by Anil Kumar on 2020-02-15
 */
class MainApplication : Application(), HasActivityInjector {

    private val TAG = MainApplication::class.java.name
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector() = activityInjector


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {

        var instance: MainApplication by Delegates.notNull()
    }

}