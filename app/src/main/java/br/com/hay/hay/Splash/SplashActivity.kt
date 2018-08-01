package br.com.hay.hay.Splash

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import br.com.hay.hay.Login.LoginActivity

import br.com.hay.hay.R

class SplashActivity : AppCompatActivity(), SplashContract.View {

    private lateinit var mPresenter : SplashPresenter
    private lateinit var mRouter: SplashRouter
    private var mContext : Context = applicationContext

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mPresenter = SplashPresenter()
        mRouter = SplashRouter(mContext)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.start()
        mRouter.goNext()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.finish()
    }

    override fun setPresenter(presenter: SplashContract.Presenter) {
        mPresenter = presenter as SplashPresenter;
    }

}
