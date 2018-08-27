package br.com.hay.register

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {

    companion object {
        private const val REGISTER_USER: String = "/register"
    }

    @POST(REGISTER_USER) fun registerUser(@Body user: User): Call<User>
}