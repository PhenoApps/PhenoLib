package org.phenoapps.interfaces.security

interface SecureLocation: SecureInterface {
    companion object {
        const val TAG = "${SecureInterface.TAG}/F"
    }
    fun withLocation(onResult: () -> Unit)
}