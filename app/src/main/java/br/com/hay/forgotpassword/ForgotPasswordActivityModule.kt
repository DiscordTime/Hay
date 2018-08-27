package br.com.hay.forgotpassword

import br.com.hay.app.HayApplication
import br.com.hay.base.NetworkHandler
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun forgotPasswordActivityModule(application: HayApplication) = Kodein.Module("forgotPasswordActivityModule") {
    bind<ForgotPasswordRepository>() with provider { ForgotPasswordRepositoryImpl(instance(),
            NetworkHandler(application), instance()) }
    bind<ForgotPassword>() with provider { ForgotPassword(instance()) }
    bind<ForgotPasswordPresenter>() with provider { ForgotPasswordPresenter(instance(), instance()) }
    bind<ForgotPasswordService>() with singleton { ForgotPasswordServiceImpl(instance()) }
}