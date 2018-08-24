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
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun appModule(appContext: Context) = Kodein.Module("appModule") {
    bind<Context>() with provider { appContext }
    bind<IRouter>() with provider { Router(instance()) }
    bind<Logger>() with singleton { AndroidLogger() }
    import(httpAppModule())
}

fun httpAppModule() = Kodein.Module("httpModule") {
    bind<OkHttpClient>() with singleton { httpClient() }
    bind<Retrofit>() with singleton {
        Retrofit.Builder().baseUrl("http://142.93.60.236:8080")
                .client(instance())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}
