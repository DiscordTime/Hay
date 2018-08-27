package br.com.hay.register

import br.com.hay.base.BaseUseCase
import br.com.hay.register.RegisterUser.Params

class RegisterUser(private val registerRepository: RegisterRepository)
    : BaseUseCase<User, Params>() {

    override suspend fun run(params: Params) =
            registerRepository.registerUser(params.name, params.email, params.password)

    data class Params(val name: String, val email: String, val password: String)
}