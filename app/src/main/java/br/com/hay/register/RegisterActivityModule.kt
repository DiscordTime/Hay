package br.com.hay.register

import br.com.hay.app.HayApplication
import br.com.hay.base.NetworkHandler
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun registerActivityModule(application: HayApplication) = Kodein.Module("registerActivityModule") {
    bind<RegisterRepository>() with provider { RegisterRepositoryImpl(instance(), NetworkHandler(application), instance()) }
    bind<RegisterUser>() with provider { RegisterUser(instance()) }
    bind<RegisterPresenter>() with provider { RegisterPresenter(instance(), instance()) }
    bind<RegisterService>() with singleton { RegisterServiceImpl(instance()) }
}