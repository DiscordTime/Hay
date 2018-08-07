package br.com.hay.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import br.com.hay.R
import br.com.hay.app.HayApplication

class SplashActivity : AppCompatActivity(), SplashContract.View {

    private val SPLASH_DELAY: Long = 3000
    private var SplashScreen: Int = 1
    private val SplashScreenFinishCount: String = "SplashFinish"
    private var mDelayHandler: Handler? = null
    private lateinit var mPresenter : SplashPresenter
    internal var mRunnable: Runnable = Runnable {
        if  (!isFinishing) {
            (application as HayApplication).getRouter()?.
                    goNext(SplashScreen, SplashScreenFinishCount)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mPresenter = SplashPresenter()
        mDelayHandler = Handler()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.start()
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.finish()
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
    }

    override fun setPresenter(presenter: SplashContract.Presenter) {
        mPresenter = presenter as SplashPresenter;
    }

}
