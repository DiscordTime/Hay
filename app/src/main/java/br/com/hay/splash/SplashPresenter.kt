package br.com.hay.splash

import br.com.hay.base.BasePresenter
import br.com.hay.handler.IDelayHandler
import br.com.hay.router.IRouter

private const val SPLASH_DELAY: Long = 3000

class SplashPresenter(private val router: IRouter?, private val delayHandler: IDelayHandler?):
        BasePresenter<SplashContract.View>() {

    override fun resume(baseView: SplashContract.View) {
        super.resume(baseView)
        delayHandler?.start(SPLASH_DELAY, Runnable {
            router?.goNext(IRouter.SPLASH_SCREEN, IRouter.SPLASH_SCREEN_FINISH)})
    }

    override fun pause(){
        super.pause()
        delayHandler?.destroy()
    }
}