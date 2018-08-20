package br.com.hay.base

abstract class BasePresenter<T: BaseView> {

    var mView: T? = null

   open fun resume(baseView: T) {
       mView = baseView
   }

   open fun pause() {
       mView = null
   }

}