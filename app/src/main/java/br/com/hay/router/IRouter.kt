package br.com.hay.router

import br.com.hay.base.BaseActivity
import br.com.hay.wrapper.ContextWrapper

interface IRouter {

    companion object {
        const val SPLASH_SCREEN: Int = 1
        const val LOGIN_SCREEN: Int = 2

        const val SPLASH_SCREEN_FINISH: String = "splash_screen_finish"
        const val LOGIN_SCREEN_REGISTER: String = "login_screen_register"
        const val LOGIN_SCREEN_FORGOT_PASSWORD: String = "login_screen_forgot_password"
    }

    fun setContext(context: ContextWrapper)

    fun goNext(from : Int, event : String)

}