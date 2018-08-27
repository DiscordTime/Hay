package br.com.hay.forgotpassword

import br.com.hay.base.BasePresenter
import br.com.hay.base.BaseView

class ForgotPasswordContract {

    interface View: BaseView {
        fun getEmail(): String
        fun showError(message: String)
    }

    abstract class Presenter: BasePresenter<View>() {
        abstract fun sendClick()
    }

}