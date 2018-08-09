package br.com.hay.splash

import android.os.Bundle
import br.com.hay.*

import br.com.hay.app.HayApplication
import br.com.hay.base.*
import br.com.hay.handler.HayDelayHandler
import br.com.hay.handler.IDelayHandler
import br.com.hay.wrapper.ContextWrapper
import br.com.hay.wrapper.ContextWrapperImpl

class SplashActivity : BaseActivity(), SplashContract.View {

    private lateinit var mPresenter : SplashPresenter
    private lateinit var mHandler: IDelayHandler
    private lateinit var mContextWrapper: ContextWrapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mHandler = HayDelayHandler()
        mContextWrapper = ContextWrapperImpl(getActivityContext())
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

}
