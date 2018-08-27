package br.com.hay.forgotpassword

import br.com.hay.base.BaseView
import br.com.hay.base.Failure
import br.com.hay.forgotpassword.ForgotPassword
import br.com.hay.router.IRouter

class ForgotPasswordPresenter(private val router : IRouter,
                              private val forgotPassword: ForgotPassword):
        ForgotPasswordContract.Presenter() {

    override fun resume(baseView: ForgotPasswordContract.View) {
        super.resume(baseView)
    }

    override fun pause(){
        super.pause()
    }

    override fun sendClick() {
        val view = getView()
        val email = view!!.getEmail()

        forgotPassword(email)
    }

    private fun forgotPassword(email: String) =
            forgotPassword.invoke(ForgotPassword.Params(email),
                    { it.either(::handleFailure, ::handleSuccess)})

    private fun handleSuccess(boolean: Boolean) {
        router.goNext(IRouter.FORGOT_PASSWORD_SCREEN, IRouter.FORGOT_PASSWORD_SCREEN_FINISH)
    }

    private fun handleFailure(failure: Failure) {
        val view = getView()
        view!!.showError(failure.toString())
    }

}