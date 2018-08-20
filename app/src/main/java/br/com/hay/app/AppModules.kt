package br.com.hay.app

import android.content.Context
import br.com.hay.base.Logger
import br.com.hay.base.httpClient
import br.com.hay.router.IRouter
import br.com.hay.router.Router
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun appModule(appContext: Context) = Kodein.Module("appModule") {
    bind<Context>() with provider { appContext }
    bind<IRouter>() with provider { Router(instance()) }
    bind<Logger>() with singleton { AndroidLogger() }
    import(httpAppModule())
}

fun httpAppModule() = Kodein.Module("httpModule") {
    bind<OkHttpClient>() with singleton { httpClient() }
}
