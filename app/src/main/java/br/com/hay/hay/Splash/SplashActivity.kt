package br.com.hay.hay.Splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

import br.com.hay.hay.Login.LoginActivity

import br.com.hay.hay.R

class SplashActivity : AppCompatActivity(), SplashContract.View {

    private lateinit var mPresenter : SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.start();
    }

    override fun setPresenter(presenter: SplashContract.Presenter) {
        mPresenter = checkNotNull(presenter);
    }

}
