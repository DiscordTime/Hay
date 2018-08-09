package br.com.hay.splash

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.hay.*

import br.com.hay.app.HayApplication

class SplashActivity : AppCompatActivity(), SplashContract.View, ActivityWrapper {

    private lateinit var mPresenter : SplashPresenter
    private lateinit var mHandler: IDelayHandler
    private lateinit var mContextWrapper: ContextWrapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mHandler = HayDelayHandler()
        mContextWrapper = ContextWrapperImpl(this)
        mPresenter = SplashPresenter(
                (application as HayApplication).getRouter(mContextWrapper), mHandler)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.finish()
    }

    override fun setPresenter(presenter: SplashContract.Presenter) {
        mPresenter = presenter as SplashPresenter;
    }

    override fun getActivityContext(): Activity {
        return this
    }

}
