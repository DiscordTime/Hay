package br.com.hay.base

import okhttp3.OkHttpClient

fun httpClient(): OkHttpClient =
    OkHttpClient.Builder().build()
