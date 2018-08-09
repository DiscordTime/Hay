package br.com.hay

interface IDelayHandler {
    fun start(count : Long, runnable: Runnable)
    fun destroy()
}