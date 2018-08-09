package br.com.hay

interface ContextWrapper {
    fun goNext(className: Class<out ActivityWrapper>)
}