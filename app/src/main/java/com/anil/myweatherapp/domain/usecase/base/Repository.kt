package com.anil.myweatherapp.domain.usecase.base

/**
 * Created by Anil Kumar on 2020-02-17
 */
interface Repository<T> {

    fun storeToDB(obj: T)
}