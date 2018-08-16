package br.com.hay.login

import br.com.hay.router.IRouter

class ForgotPasswordPresenter(private val router : IRouter?) :
        ForgotPasswordContract.Presenter {

    private var mView : ForgotPasswordContract.View? = null

    override fun start(baseView: ForgotPasswordContract.View) {
        mView = baseView
    }

    override fun finish(){
        mView = null
    }

    override fun sendClick() {
        TODO("not implemented")
    }

}