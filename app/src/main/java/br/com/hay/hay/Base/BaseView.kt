package br.com.hay.hay.Base

interface BaseView<T> {
    fun setPresenter(presenter: T)
}