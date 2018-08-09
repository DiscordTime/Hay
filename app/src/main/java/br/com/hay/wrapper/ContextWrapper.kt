package br.com.hay.wrapper

interface ContextWrapper {
    fun goNext(className: Class<out ActivityWrapper>, shouldClearStack : Boolean)
}