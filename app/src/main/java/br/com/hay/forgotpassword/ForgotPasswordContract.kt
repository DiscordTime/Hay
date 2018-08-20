package br.com.hay.login

import br.com.hay.base.BasePresenter
import br.com.hay.base.BaseView

class ForgotPasswordContract {

    interface View: BaseView {
        fun getEmail(): String
    }

    abstract class Presenter: BasePresenter<View>() {
        abstract fun sendClick()
    }

}