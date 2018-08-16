package br.com.hay.login

import br.com.hay.router.IRouter

class LoginPresenter(private val router : IRouter?) :
        LoginContract.Presenter {

    private var mView : LoginContract.View? = null

    override fun start(baseView: LoginContract.View) {
        mView = baseView
    }

    override fun finish(){
        mView = null
    }

    override fun loginClick() {
        TODO("not implemented")
    }

    override fun registerClick() {
        router?.goNext(IRouter.LOGIN_SCREEN, IRouter.LOGIN_SCREEN_REGISTER)
    }

    override fun forgotPasswordClick() {
        router?.goNext(IRouter.LOGIN_SCREEN, IRouter.LOGIN_SCREEN_FORGOT_PASSWORD)
    }

}