package com.coppel.test.domain.utils.network

import java.io.IOException

/**
 * Exception for lack of connection to internet networks
 */
class NoConnectivityException : IOException() {
    override val message: String
        get() = "No internet connection"
}