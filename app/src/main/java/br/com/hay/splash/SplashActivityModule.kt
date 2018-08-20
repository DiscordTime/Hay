package br.com.hay.splash

import br.com.hay.handler.HayDelayHandler
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

fun splashActivityModule() = Kodein.Module("splashActivityModule") {
    bind<SplashPresenter>() with provider {
        SplashPresenter(instance(), HayDelayHandler())
    }
}