package br.com.hay.login

import br.com.hay.base.BaseView
import br.com.hay.router.IRouter

class ForgotPasswordPresenter(private val router : IRouter?):
        ForgotPasswordContract.Presenter() {

    override fun resume(baseView: ForgotPasswordContract.View) {
        super.resume(baseView)
        //TODO
    }

    override fun pause(){
        super.pause()
        //TODO
    }

    override fun sendClick() {
        TODO("not implemented")
    }

}