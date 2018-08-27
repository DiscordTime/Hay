package br.com.hay.forgotpassword

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ForgotPasswordApi {

    companion object {
        private const val FORGOT_PASSWORD: String = "/forgotpassword"
        private const val FORGOT_PASSWORD_PARAM_EMAIL: String = "email"
    }

    @GET(FORGOT_PASSWORD) fun forgotPassword(
            @Query(FORGOT_PASSWORD_PARAM_EMAIL) email: String): Call<Boolean>
}