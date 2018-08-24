package br.com.hay.login

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApi {

    companion object {
        private const val AUTH_USER: String = "/login"
        private const val AUTH_USER_PARAM_EMAIL: String = "email"
        private const val AUTH_USER_PARAM_PASSWORD: String = "password"
    }

    @GET(AUTH_USER) fun authUser(@Query(AUTH_USER_PARAM_EMAIL) email: String,
                                 @Query(AUTH_USER_PARAM_PASSWORD) password: String): Call<User>
}