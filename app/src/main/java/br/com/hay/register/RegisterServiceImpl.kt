package br.com.hay.register

import retrofit2.Retrofit

class RegisterServiceImpl(retrofit: Retrofit) : RegisterService {

    private val registerApi by lazy {
        retrofit.create(RegisterApi::class.java)
    }

    override fun registerUser(user: User)
            = registerApi.registerUser(user)

}