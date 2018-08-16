package br.com.hay.login

import br.com.hay.router.IRouter

class RegisterPresenter(private val router : IRouter?) :
        RegisterContract.Presenter {

    private var mView : RegisterContract.View? = null

    override fun start(baseView: RegisterContract.View) {
        mView = baseView
    }

    override fun finish(){
        mView = null
    }

    override fun sendClick() {
        TODO("not implemented")
    }

}