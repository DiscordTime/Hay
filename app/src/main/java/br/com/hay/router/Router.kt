package br.com.hay.router

import br.com.hay.wrapper.ContextWrapper

import br.com.hay.login.LoginActivity

class Router : IRouter {

    private lateinit var mContext : ContextWrapper

    override fun setContext(context: ContextWrapper) {
        mContext = context
    }


    override fun goNext(from : Int, event : String) {
        if (from.equals(IRouter.SPLASH_SCREEN) && event.equals(IRouter.SPLASH_SCREEN_FINISH)){
            mContext.goNext(LoginActivity::class.java, true)
        }
    }
}