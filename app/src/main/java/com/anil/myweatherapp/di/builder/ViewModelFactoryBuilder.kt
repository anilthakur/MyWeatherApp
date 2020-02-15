package com.android.artgallery.di.builder

import androidx.lifecycle.ViewModelProvider
import com.anil.myweatherapp.persentation.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
/**
 * Created by Anil Kumar on 2020-02-11
 */
@Module(includes = [(ViewModelsBuilder::class)])
abstract class ViewModelFactoryBuilder {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}