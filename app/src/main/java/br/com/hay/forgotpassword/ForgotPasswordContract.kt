package br.com.hay.login

import br.com.hay.base.BasePresenter
import br.com.hay.base.BaseView

class ForgotPasswordContract {

    interface View : BaseView<Presenter> {
        fun getEmail(): String
    }

    interface Presenter : BasePresenter<View> {
        fun sendClick()
    }
}