package br.com.hay.router

import android.content.Context
import android.content.Intent
import android.util.Log

import br.com.hay.login.LoginActivity

class Router(context : Context) {

    private var SplashScreen: Int = 1
    private val SplashScreenFinishCount: String = "SplashFinish"

    private var mContext : Context = context

    fun goNext(from : Int, event : String) {

        if (from.equals(SplashScreen) && event.equals(SplashScreenFinishCount)){

            val intent = Intent(mContext, LoginActivity::class.java)
            mContext.startActivity(intent)
        }
    }

    fun goBack(from: String){

    }

}