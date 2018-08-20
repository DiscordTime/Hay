package br.com.hay.app

import android.util.Log
import br.com.hay.base.Logger

class AndroidLogger : Logger {

    companion object {
        private const val APP_TAG = "HAY";
    }

    override fun log(tag: String, level: Logger.Level, message: String) {
        when(level) {
            Logger.Level.Info     -> Log.i(APP_TAG, "[$tag] $message")
            Logger.Level.Debug    -> Log.d(APP_TAG, "[$tag] $message")
            Logger.Level.Warning  -> Log.w(APP_TAG, "[$tag] $message")
            Logger.Level.Error    -> Log.e(APP_TAG, "[$tag] $message")
            Logger.Level.Verbose  -> Log.v(APP_TAG, "[$tag] $message")
        }
    }

}