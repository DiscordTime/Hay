package br.com.hay.base

interface BaseView<T> {
    fun setPresenter(presenter: T)
}