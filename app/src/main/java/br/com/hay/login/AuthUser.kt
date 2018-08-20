package br.com.hay.login

import br.com.hay.base.BaseUseCase
import br.com.hay.login.AuthUser.Params

class AuthUser(private val loginRepository: LoginRepository)
    : BaseUseCase<User, Params>() {

    override suspend fun run(params: Params) =
        loginRepository.authUser(params.email, params.password)

    data class Params(val email: String, val password: String)
}