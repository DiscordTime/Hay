package br.com.hay.register

import br.com.hay.base.BasePresenter
import br.com.hay.base.BaseView

class RegisterContract {

    interface View : BaseView {
        fun getName(): String
        fun getEmail(): String
        fun getPassword(): String
        fun showError(message: String)
    }

    abstract class Presenter: BasePresenter<View>() {
        abstract fun sendClick()
    }
}