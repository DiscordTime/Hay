package br.com.hay.login

import br.com.hay.base.Either
import br.com.hay.base.Failure

interface LoginRepository {

    fun authUser(email: String, password: String): Either<Failure, User>

}