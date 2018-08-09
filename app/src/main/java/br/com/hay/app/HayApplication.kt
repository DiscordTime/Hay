package br.com.hay.app

import android.app.Application
import br.com.hay.ContextWrapper
import br.com.hay.router.IRouter
import br.com.hay.router.Router

class HayApplication : Application() {

    private var mRouter: IRouter? = null

    override fun onCreate() {
        super.onCreate()
        mRouter = Router()
    }

    fun getRouter(contextWrapper: ContextWrapper) : IRouter?{
        mRouter?.setContext(contextWrapper)
        return mRouter
    }


}