package br.com.hay.router

import br.com.hay.forgotpassword.ForgotPasswordActivity
import br.com.hay.wrapper.ContextWrapper

import br.com.hay.login.LoginActivity
import br.com.hay.register.RegisterActivity

class Router : IRouter {

    private lateinit var mContext : ContextWrapper

    override fun setContext(context: ContextWrapper) {
        mContext = context
    }

    override fun goNext(from : Int, event : String) {
        if (from.equals(IRouter.SPLASH_SCREEN) && event.equals(IRouter.SPLASH_SCREEN_FINISH)){
            mContext?.goNext(LoginActivity::class.java, true)
        } else if(from.equals(IRouter.LOGIN_SCREEN)
                && event.equals(IRouter.LOGIN_SCREEN_REGISTER)) {
            mContext?.goNext(RegisterActivity::class.java, false)
        } else if (from.equals(IRouter.LOGIN_SCREEN)
                && event.equals(IRouter.LOGIN_SCREEN_FORGOT_PASSWORD)) {
            mContext?.goNext(ForgotPasswordActivity::class.java, false)
        }
    }
}