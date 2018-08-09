package br.com.hay.handler

interface IDelayHandler {
    fun start(count : Long, runnable: Runnable)
    fun destroy()
}