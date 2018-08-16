package br.com.hay.login

import br.com.hay.base.BasePresenter
import br.com.hay.base.BaseView

class LoginContract {

    interface View : BaseView<Presenter> {
        fun getEmail(): String
        fun getPassword(): String
    }

    interface Presenter : BasePresenter<View> {
        fun loginClick()
        fun registerClick()
        fun forgotPasswordClick()
    }
}