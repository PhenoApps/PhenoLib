package org.phenoapps.interfaces.security

interface SecureFragmentInterface: SecureInterface {
    companion object {
        const val TAG = "${SecureInterface.TAG}/F"
    }
    fun initialize()
    fun withPermission(permissions: Array<String>, onResult: () -> Unit)
}