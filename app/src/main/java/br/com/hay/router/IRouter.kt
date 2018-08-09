package br.com.hay.router

import br.com.hay.ActivityWrapper
import br.com.hay.ContextWrapper

interface IRouter {

    companion object {
        val SPLASH_SCREEN: Int = 1
        val SPLASH_SCREEN_FINISH : String = "splash_screen_finish"
    }

    fun setContext(context: ContextWrapper)

    fun goNext(from : Int, event : String)

}