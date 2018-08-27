package br.com.hay.register

import retrofit2.Call

interface RegisterService {

    fun registerUser(user: User): Call<User>

}