package br.com.hay.login

import br.com.hay.router.IRouter

class LoginPresenter(private val router: IRouter?, private val authUser: AuthUser?) :
        LoginContract.Presenter() {

    override fun resume(view: LoginContract.View) {
        super.resume(view)
    }

    override fun pause() {
        super.pause()
    }

    override fun loginClick() {

    }

    override fun registerClick() {
        router?.goNext(IRouter.LOGIN_SCREEN, IRouter.LOGIN_SCREEN_REGISTER)
    }

    override fun forgotPasswordClick() {
        router?.goNext(IRouter.LOGIN_SCREEN, IRouter.LOGIN_SCREEN_FORGOT_PASSWORD)
    }

}