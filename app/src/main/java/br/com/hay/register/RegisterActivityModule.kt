package br.com.hay.register

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

fun registerActivityModule() = Kodein.Module("registerActivityModule") {
    bind<RegisterPresenter>() with provider {
        RegisterPresenter(instance())
    }
}