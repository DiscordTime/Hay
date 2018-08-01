package br.com.hay.hay.Splash

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity

import br.com.hay.hay.Login.LoginActivity

class SplashRouter(context : Context) : SplashContract.Router {

    private var mContext : Context = context

    override fun goNext() {
        val intent = Intent(mContext, LoginActivity::class.java)
        mContext.startActivity(intent)
    }
}