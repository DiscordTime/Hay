package br.com.hay.hay.Splash

import br.com.hay.hay.Base.BasePresenter
import br.com.hay.hay.Base.BaseView

class SplashContract {

    interface View : BaseView<Presenter> {
    }

    interface Presenter : BasePresenter {
        fun finish()
    }

    interface Router{
        fun goNext()
    }
}