package br.com.hay.router

interface IRouter {

    companion object {
        const val SPLASH_SCREEN: Int = 1
        const val LOGIN_SCREEN: Int = 2

        const val SPLASH_SCREEN_FINISH: String = "splash_screen_finish"
        const val LOGIN_SCREEN_REGISTER: String = "login_screen_register"
        const val LOGIN_SCREEN_FORGOT_PASSWORD: String = "login_screen_forgot_password"
    }
  
    fun goNext(from : Int, event : String)

}