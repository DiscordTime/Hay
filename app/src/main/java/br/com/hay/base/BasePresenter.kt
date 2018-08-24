package br.com.hay.base

import androidx.lifecycle.MutableLiveData

abstract class BasePresenter<T: BaseView> {

    var mView: T? = null
    var failure: MutableLiveData<Failure> = MutableLiveData()

    open fun resume(baseView: T) {
       mView = baseView
   }

   open fun pause() {
       mView = null
   }

   open fun getView(): T? {
       return mView
   }

}