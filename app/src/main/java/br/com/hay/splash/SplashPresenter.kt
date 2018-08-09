package br.com.hay.splash

import br.com.hay.IDelayHandler
import br.com.hay.router.IRouter

class SplashPresenter(val router : IRouter?, val delayHandler: IDelayHandler?) :
        SplashContract.Presenter {

    private val SPLASH_DELAY: Long = 3000

    override fun start() {
        delayHandler?.start(SPLASH_DELAY, Runnable {
            router?.goNext(IRouter.SPLASH_SCREEN, IRouter.SPLASH_SCREEN_FINISH) })
    }

    override fun finish(){
        delayHandler?.destroy()
    }
}