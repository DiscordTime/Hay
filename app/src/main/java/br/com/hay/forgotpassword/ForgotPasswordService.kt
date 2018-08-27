package br.com.hay.forgotpassword

import retrofit2.Call

interface ForgotPasswordService {

    fun forgotPassword(email: String): Call<Boolean>

}