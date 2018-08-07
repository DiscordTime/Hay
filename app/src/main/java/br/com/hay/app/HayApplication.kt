package br.com.hay.app

import android.app.Application
import android.content.Context
import br.com.hay.router.Router

class HayApplication : Application() {

    private var mRouter: Router? = null

    override fun onCreate() {
        super.onCreate()
        mRouter = Router(applicationContext)
    }

    fun getRouter() : Router?{
        return mRouter
    }


}