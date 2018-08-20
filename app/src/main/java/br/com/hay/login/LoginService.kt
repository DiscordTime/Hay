package br.com.hay.login

import retrofit2.Call

interface LoginService {

    fun authUser(email: String, password: String): Call<User>

}