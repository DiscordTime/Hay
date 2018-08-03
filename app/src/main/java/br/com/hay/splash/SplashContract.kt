package br.com.hay.splash

import br.com.hay.base.BasePresenter
import br.com.hay.base.BaseView

class SplashContract {

    interface View : BaseView<Presenter>

    interface Presenter : BasePresenter
}