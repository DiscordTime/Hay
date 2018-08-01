package br.com.hay.hay.Splash

import android.os.Handler

class SplashPresenter : SplashContract.Presenter {

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000
    private lateinit var mRouter: SplashRouter
    internal val mRunnable: Runnable = Runnable {}

    override fun start() {
        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

    override fun finish(){
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
    }

}