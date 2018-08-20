package br.com.hay.login

import br.com.hay.base.BaseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginApi : BaseApi {

    companion object {
        private const val AUTH_USER: String = "/path/to/auth/user"
        private const val AUTH_USER_PARAM_EMAIL: String = "email"
        private const val AUTH_USER_PARAM_PASSWORD: String = "email"
    }

    @GET(AUTH_USER) fun authUser(@Path(AUTH_USER_PARAM_EMAIL) email: String,
                                 @Path(AUTH_USER_PARAM_PASSWORD) password: String): Call<User>
}