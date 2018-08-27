package br.com.hay.register

import br.com.hay.base.Either
import br.com.hay.base.Failure

interface RegisterRepository {

    fun registerUser(name: String, email: String, password: String): Either<Failure, User>

}