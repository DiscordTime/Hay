package br.com.hay.splash

import br.com.hay.handler.IDelayHandler
import br.com.hay.router.IRouter

private const val SPLASH_DELAY: Long = 3000

class SplashPresenter(private val router: IRouter?, private val delayHandler: IDelayHandler?) :
        SplashContract.Presenter {

    private var mView: SplashContract.View? = null

    override fun start(view: SplashContract.View) {
        mView = view
        delayHandler?.start(SPLASH_DELAY, Runnable {
            router?.goNext(IRouter.SPLASH_SCREEN, IRouter.SPLASH_SCREEN_FINISH)})
    }

    override fun finish(){
        mView = null
        delayHandler?.destroy()
    }
}