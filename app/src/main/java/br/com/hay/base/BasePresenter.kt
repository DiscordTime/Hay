package br.com.hay.base

interface BasePresenter<BaseView> {

   fun start(baseView: BaseView)
   fun finish()

}