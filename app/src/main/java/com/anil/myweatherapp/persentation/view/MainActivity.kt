package com.anil.myweatherapp.persentation.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.anil.myweatherapp.R
import com.anil.myweatherapp.domain.model.forecastmodule.ListItem
import com.anil.myweatherapp.persentation.adapter.ForeCastAdapter
import com.anil.myweatherapp.persentation.viewmodel.WeatherViewModel
import com.anil.myweatherapp.utils.Utils
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var adapter: ForeCastAdapter? = null

    private val viewModel: WeatherViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(WeatherViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loadCurrentWeather(
            getString(R.string.city_name),
            getString(R.string.metrics),
            getString(R.string.api_key)
        )
        viewModel.loadForeCastWeather(
            getString(R.string.city_name),
            getString(R.string.metrics),
            getString(R.string.api_key)
        )

        viewModel.isLoad.observe(this, Observer {
            it.let {
                if (!it) {
                    loader.visibility = View.VISIBLE
                    mainContainer.visibility = View.GONE
                } else {
                    loader.visibility = View.GONE
                    mainContainer.visibility = View.VISIBLE
                }
            }
        })

        viewModel.isError.observe(this, Observer {
            it.let {
                if (it == true) {
                    errorText.visibility = View.VISIBLE
                    mainContainer.visibility = View.GONE
                } else {
                    errorText.visibility = View.GONE
                    mainContainer.visibility = View.VISIBLE
                }
            }
        })

        viewModel.weatherLiveData.observe(this, Observer {
            it?.let {
                val temp = it.main?.temp.toString() + getString(R.string.unit)
                val tempMin =
                    getString(R.string.min_temp) + it.main?.tempMin + getString(R.string.unit)
                val tempMax =
                    getString(R.string.max_temp) + it.main?.tempMax + getString(R.string.unit)
                val pressure = it.main?.pressure
                val humidity = it.main?.humidity
                val sunrise = it.sys?.sunrise
                val sunset = it.sys?.sunset
                val windSpeed = it.wind?.speed
                val weatherDescription = it.weather?.get(0)?.description
                address.text = it.name + "" + it.sys?.country
                updated_at.text =
                    getString(R.string.updated_text) + it.dt?.let { it1 ->
                        Utils.convertDateFormatfromMillisecond(
                            it1
                        )
                    }
                status.text = weatherDescription
                temp_textview.text = temp
                temp_min.text = tempMin
                temp_max.text = tempMax
                sunrise_text.text =
                    sunrise?.let { it1 -> Utils.convertTimeFormatfromMillisecond(it1) }
                sunset_text.text =
                    sunset?.let { it1 -> Utils.convertTimeFormatfromMillisecond(it1) }
                wind.text = "" + windSpeed
                pressure_text.text = "" + pressure
                humidity_text.text = "" + humidity
            }
        })

        viewModel.weatherForecastLiveData.observe(this, Observer {
            it?.let {
                val listItems = ArrayList<ListItem>()
                for (i in 0 until it.list?.size!!) {
                    it.list.get(i)?.let { it1 -> listItems.add(it1) }
                }

                adapter = ForeCastAdapter(this, Utils.removeDuplicates(listItems))
                recyclerView.adapter = adapter
                recyclerView.layoutManager =
                    LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

            }
        })
    }
}
