package br.com.hay.login

import br.com.hay.base.Either
import br.com.hay.base.Failure
import br.com.hay.base.NetworkHandler
import retrofit2.Call

class LoginRepositoryImpl(private val loginService: LoginService,
                          private val networkHandler: NetworkHandler) : LoginRepository {

    override fun authUser(email: String, password: String) : Either<Failure, User> {
        return when (networkHandler.isConnected) {
            true -> request(loginService.authUser(email, password), { it }, User.empty())
            false, null -> Either.Left(Failure.NetworkConnection())
        }
    }

    private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError())
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError())
        }
    }
}