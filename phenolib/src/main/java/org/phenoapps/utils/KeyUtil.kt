package org.phenoapps.utils

import android.content.Context
import org.phenoapps.androidlibrary.R
import kotlin.properties.ReadOnlyProperty

/**
 * Utility class for easily accessing preference keys.
 * Converts keys.xml into string fields to be accessed within a context.
 */
open class KeyUtil(private val ctx: Context?) {

    fun key(id: Int): ReadOnlyProperty<Any?, String> =
        ReadOnlyProperty { _, _ -> ctx?.getString(id)!! }

    val defaultTreeUri by key(R.string.key_default_uri)

    open val isFirstInstall by key(R.string.key_first_install)
    open val enableMigrator by key(R.string.key_enable_migrator)

    //database preference settings keys
    open val exportDatabase by key(R.string.key_pref_database_export)
    open val importDatabase by key(R.string.key_pref_database_import)
    open val database by key(R.string.key_pref_database)
    open val deleteDatabase by key(R.string.key_pref_database_delete)

    //definer preference keys
    open val prefDefiner by key(R.string.key_pref_definer)
}