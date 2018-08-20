package br.com.hay.app

import android.app.Application
import androidx.annotation.VisibleForTesting
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class HayApplication : Application(), KodeinAware {

    @VisibleForTesting
    var overrideBindings: Kodein.MainBuilder.() -> Unit = {}

    override val kodein = Kodein.lazy {
        import(appModule(applicationContext))
    }

}