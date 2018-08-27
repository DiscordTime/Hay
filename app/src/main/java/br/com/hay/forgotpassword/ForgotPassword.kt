package br.com.hay.forgotpassword

import br.com.hay.base.BaseUseCase
import br.com.hay.forgotpassword.ForgotPassword.Params

class ForgotPassword(private val forgotPasswordRepository: ForgotPasswordRepository)
    : BaseUseCase<Boolean, Params>() {

    override suspend fun run(params: Params) =
            forgotPasswordRepository.forgotPassword(params.email)

    data class Params(val email: String)
}