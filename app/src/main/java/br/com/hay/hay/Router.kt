package br.com.hay.hay

import android.content.Context
import android.content.Intent
import android.os.Handler

import br.com.hay.hay.Login.LoginActivity

class Router(context : Context) {

    private var SplashScreen: Int = 1

    private var mContext : Context = context

    fun goNext(from : Int) {

        if (from.equals(SplashScreen)){
            val intent = Intent(mContext, LoginActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    fun goBack(from: String){

    }
}