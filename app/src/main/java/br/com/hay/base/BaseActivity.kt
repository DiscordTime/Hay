package br.com.hay.base

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import br.com.hay.app.HayApplication
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein

abstract class BaseActivity : AppCompatActivity(), KodeinAware {

    private val appKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(appKodein)
        import(baseActivityModule(this@BaseActivity), allowOverride = true)
        import(activityModule())
        (app().overrideBindings)()
    }

    /**
     * Optional to override, if your activity needs specific DI.
     */
    open fun activityModule() = Kodein.Module("activityModule") {}

    fun Activity.app() = applicationContext as HayApplication

}