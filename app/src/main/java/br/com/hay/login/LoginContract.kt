package br.com.hay.login

import br.com.hay.base.BasePresenter
import br.com.hay.base.BaseView

class LoginContract {

    interface View: BaseView {
        fun getEmail(): String
        fun getPassword(): String
        fun showError(messge: String)
    }

    abstract class Presenter: BasePresenter<View>() {
        abstract fun loginClick()
        abstract fun registerClick()
        abstract fun forgotPasswordClick()
    }

}