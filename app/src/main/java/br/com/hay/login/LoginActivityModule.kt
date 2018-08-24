package br.com.hay.login

import br.com.hay.app.HayApplication
import br.com.hay.base.NetworkHandler
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun loginActivityModule(application: HayApplication) = Kodein.Module("loginActivityModule") {
    bind<LoginRepository>() with provider { LoginRepositoryImpl(instance(), NetworkHandler(application), instance()) }
    bind<AuthUser>() with provider { AuthUser(instance()) }
    bind<LoginPresenter>() with provider { LoginPresenter(instance(), instance()) }
    bind<LoginService>() with singleton { LoginServiceImpl(instance()) }
}