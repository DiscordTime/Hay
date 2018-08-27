package br.com.hay.router

interface IRouter {

    companion object {
        const val SPLASH_SCREEN: Int = 1
        const val LOGIN_SCREEN: Int = 2
        const val REGISTER_SCREEN: Int = 3
        const val FORGOT_PASSWORD_SCREEN: Int = 4

        const val SPLASH_SCREEN_FINISH: String = "splash_screen_finish"
        const val LOGIN_SCREEN_REGISTER: String = "login_screen_register"
        const val LOGIN_SCREEN_FORGOT_PASSWORD: String = "login_screen_forgot_password"
        const val LOGIN_SCREEN_FINISH: String = "login_screen_finish"
        const val REGISTER_SCREEN_FINISH: String = "register_screen_finish"
        const val FORGOT_PASSWORD_SCREEN_FINISH: String = "forgot_password_screen_finish"
    }

    fun goNext(from : Int, event : String)

}