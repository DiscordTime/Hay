package br.com.hay.splash

import android.os.Bundle

import br.com.hay.R
import br.com.hay.base.BaseActivity
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class SplashActivity : BaseActivity(), SplashContract.View {

    override fun activityModule() = Kodein.Module("splashActivity") {
        import(splashActivityModule())
    }

    private val mPresenter by instance<SplashPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.resume(this)
    }

    override fun onPause() {
        super.onPause()
        mPresenter.pause()
    }

}
