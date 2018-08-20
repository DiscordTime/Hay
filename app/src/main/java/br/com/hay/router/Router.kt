package br.com.hay.router

import android.content.Context
import android.content.Intent
import br.com.hay.forgotpassword.ForgotPasswordActivity
import br.com.hay.login.LoginActivity
import br.com.hay.register.RegisterActivity

class Router(private val mContext: Context) : IRouter {

    override fun goNext(from : Int, event : String) {
        if (from.equals(IRouter.SPLASH_SCREEN) && event.equals(IRouter.SPLASH_SCREEN_FINISH)) {
            val intent = Intent(mContext, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            mContext.startActivity(intent)
        } else if(from.equals(IRouter.LOGIN_SCREEN)
                && event.equals(IRouter.LOGIN_SCREEN_REGISTER)) {
            val intent = Intent(mContext, RegisterActivity::class.java)
            mContext.startActivity(intent)
        } else if (from.equals(IRouter.LOGIN_SCREEN)
                && event.equals(IRouter.LOGIN_SCREEN_FORGOT_PASSWORD)) {
            val intent = Intent(mContext, ForgotPasswordActivity::class.java)
            mContext.startActivity(intent)
        }
    }
}