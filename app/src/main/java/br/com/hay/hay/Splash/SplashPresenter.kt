package br.com.hay.hay.Splash

import android.os.Handler

import android.support.v7.app.AppCompatActivity


class SplashPresenter : SplashContract.Presenter, AppCompatActivity() {

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000
    private lateinit var mRouter: SplashRouter

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            mRouter.openLoginActivity();
        }
    }

    override fun start() {
        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

}