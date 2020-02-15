package com.android.artgallery.di.module

import com.anil.myweatherapp.persentation.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
/**
 * Created by Anil Kumar on 2020-02-11
 */
@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivityModule {

    @ContributesAndroidInjector(
        modules = [
          ]
        )
    fun galleryActivityInjector(): MainActivity

}