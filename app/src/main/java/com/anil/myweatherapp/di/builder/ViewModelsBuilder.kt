package com.android.artgallery.di.builder

import androidx.lifecycle.ViewModel
import com.android.artgallery.di.ViewModelKey
import com.anil.myweatherapp.persentation.viewmodel.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
/**
 * Created by Anil Kumar on 2020-02-11
 */
@Module
abstract class ViewModelsBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    abstract fun bindAlbumsViewModel(albumsViewModel: WeatherViewModel): ViewModel


}