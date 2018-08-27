package br.com.hay.forgotpassword

import retrofit2.Retrofit

class ForgotPasswordServiceImpl(retrofit: Retrofit) : ForgotPasswordService {

    private val forgotPasswordApi by lazy {
        retrofit.create(ForgotPasswordApi::class.java)
    }

    override fun forgotPassword(email: String)
            = forgotPasswordApi.forgotPassword(email)

}