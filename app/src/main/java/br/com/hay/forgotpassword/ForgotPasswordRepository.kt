package br.com.hay.forgotpassword

import br.com.hay.base.Either
import br.com.hay.base.Failure

interface ForgotPasswordRepository {

    fun forgotPassword(email: String): Either<Failure, Boolean>

}