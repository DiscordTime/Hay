package br.com.hay.login

import br.com.hay.base.BasePresenter
import br.com.hay.base.BaseView

class RegisterContract {

    interface View : BaseView<Presenter> {
        fun getName(): String
        fun getEmail(): String
        fun getPassword(): String
    }

    interface Presenter : BasePresenter<View> {
        fun sendClick()
    }
}