package br.com.hay.login

import retrofit2.Retrofit

class LoginServiceImpl(retrofit: Retrofit) : LoginService {

    private val loginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }

    override fun authUser(email: String, password: String) = loginApi.authUser(email, password)

}