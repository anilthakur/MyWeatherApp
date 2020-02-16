package com.anil.myweatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.android.artgallery.domain.usecase.base.SingleUseCase
import com.anil.myweatherapp.domain.model.currentwethermodel.Weather
import com.anil.myweatherapp.domain.usecase.currentweather.WeatherRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Anil Kumar on 2020-02-16
 */
@RunWith(MockitoJUnitRunner::class)
class WeatherRepo_Test {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var singleUseCase: SingleUseCase<Weather>
    @Mock
    val weatherLiveData = MutableLiveData<Weather>()
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun execute_Method(){
        singleUseCase.buildUseCaseSingle()
        then(weatherLiveData).shouldHaveNoMoreInteractions()

    }

}