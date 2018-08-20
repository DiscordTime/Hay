package br.com.hay.login

import br.com.hay.app.HayApplication
import br.com.hay.base.NetworkHandler
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun loginActivityModule(application: HayApplication) = Kodein.Module("loginActivityModule") {
    bind<LoginService>() with singleton {
        Retrofit.Builder()
                .baseUrl("https://api.unsplash.com")
                .client(instance())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(LoginService::class.java)
    }
    bind<LoginRepository>() with provider { LoginRepositoryImpl(instance(), NetworkHandler(application)) }
    bind<AuthUser>() with provider { AuthUser(instance()) }
    bind<LoginPresenter>() with provider { LoginPresenter(instance(), instance()) }
}