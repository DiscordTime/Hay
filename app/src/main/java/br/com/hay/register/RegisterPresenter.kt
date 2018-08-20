package br.com.hay.register

import br.com.hay.router.IRouter

class RegisterPresenter(private val router : IRouter?) :
        RegisterContract.Presenter() {

    override fun resume(baseView: RegisterContract.View) {
        super.resume(baseView)
    }

    override fun pause(){
        super.pause()
    }

    override fun sendClick() {
        TODO("not implemented")
    }

}