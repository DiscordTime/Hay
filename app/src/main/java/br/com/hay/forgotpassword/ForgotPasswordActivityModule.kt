package br.com.hay.forgotpassword

import br.com.hay.app.HayApplication
import br.com.hay.handler.HayDelayHandler
import br.com.hay.login.ForgotPasswordPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

fun forgotPasswordActivityModule() = Kodein.Module("forgotPasswordActivityModule") {
    bind<ForgotPasswordPresenter>() with provider {
        ForgotPasswordPresenter(instance())
    }
}