package br.com.hay.base

import android.content.Context
import br.com.hay.base.Logger
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun baseActivityModule(activity: BaseActivity) = Kodein.Module("baseActivityModule") {
    bind<Context>(overrides = true) with provider { activity }
}