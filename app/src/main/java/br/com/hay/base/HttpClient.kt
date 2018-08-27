package br.com.hay.base

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun bodyInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

fun headerInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)

fun httpClient(): OkHttpClient =
    OkHttpClient.Builder()
            .addInterceptor(bodyInterceptor())
            .addInterceptor(headerInterceptor())
            .build()
