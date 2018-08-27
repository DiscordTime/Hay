package br.com.hay.register

import br.com.hay.base.Failure
import br.com.hay.router.IRouter

class RegisterPresenter(private val router : IRouter, private val registerUser: RegisterUser) :
        RegisterContract.Presenter() {

    override fun resume(baseView: RegisterContract.View) {
        super.resume(baseView)
    }

    override fun pause(){
        super.pause()
    }

    override fun sendClick() {
        val view = getView()
        val name = view!!.getName()
        val email = view!!.getEmail()
        val password = view!!.getPassword()

        registerUser(name, email, password)
    }

    private fun registerUser(name: String, email: String, password: String)
            = registerUser.invoke(RegisterUser.Params(name, email, password),
            { it.either(::handleFailure, ::handleSuccess) })

    private fun handleSuccess(user: User) {
        router.goNext(IRouter.REGISTER_SCREEN, IRouter.REGISTER_SCREEN_FINISH)
    }

    private fun handleFailure(failure: Failure) {
        val view = getView()
        view!!.showError(failure.toString())
    }

}