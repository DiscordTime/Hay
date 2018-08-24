package br.com.hay.login

import br.com.hay.base.Failure
import br.com.hay.router.IRouter

class LoginPresenter(private val router: IRouter, private val authUser: AuthUser) :
        LoginContract.Presenter() {

    override fun resume(view: LoginContract.View) {
        super.resume(view)
    }

    override fun pause() {
        super.pause()
    }

    override fun loginClick() {
        val view = getView()
        val email = view!!.getEmail()
        val password = view!!.getPassword()
        authenticateUser(email, password)
    }

    override fun registerClick() {
        router.goNext(IRouter.LOGIN_SCREEN, IRouter.LOGIN_SCREEN_REGISTER)
    }

    override fun forgotPasswordClick() {
        router.goNext(IRouter.LOGIN_SCREEN, IRouter.LOGIN_SCREEN_FORGOT_PASSWORD)
    }

    private fun authenticateUser(email: String, password: String)
            = authUser.invoke(AuthUser.Params(email, password),
            { it.either(::handleFailure, ::handleSuccess) })

    private fun handleSuccess(user: User) {
        router.goNext(IRouter.LOGIN_SCREEN, IRouter.LOGIN_SCREEN_FINISH)
    }

    private fun handleFailure(failure: Failure) {
        val view = getView()
        view!!.showError(failure.toString())
    }

}