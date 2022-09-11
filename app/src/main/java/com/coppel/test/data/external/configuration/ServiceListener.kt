package com.coppel.test.data.external.configuration

interface ServiceListener<K, T> {
    fun onServiceSuccess(result: T)
    fun onServiceFail(error: K)
}