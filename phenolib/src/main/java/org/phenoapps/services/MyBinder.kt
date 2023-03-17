package org.phenoapps.services

import android.os.Binder
import org.phenoapps.interfaces.TraitPlugin

class MyBinder(val pluginImpl: TraitPlugin) : Binder()