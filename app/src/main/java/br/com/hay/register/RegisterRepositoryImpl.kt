package br.com.hay.register

import br.com.hay.base.Either
import br.com.hay.base.Failure
import br.com.hay.base.Logger
import br.com.hay.base.NetworkHandler
import retrofit2.Call

class RegisterRepositoryImpl(private val registerService: RegisterService,
                          private val networkHandler: NetworkHandler,
                          private val logger: Logger) : RegisterRepository {

    override fun registerUser(name: String, email: String, password: String) : Either<Failure, User> {
        logger.log("RegisterRepositoryImpl", Logger.Level.Debug, "Network is connected: " + networkHandler.isConnected)
        return when (networkHandler.isConnected) {
            true -> request(registerService.registerUser(User(-1 ,name, email, password, String.empty())), { it.toUser() }, User.empty())
            false, null -> Either.Left(Failure.NetworkConnection())
        }
    }

    private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            logger.log("RegisterRepositoryImpl", Logger.Level.Debug, response.toString())
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError())
            }
        } catch (exception: Throwable) {
            logger.log("RegisterRepositoryImpl", Logger.Level.Error, exception.message!!)
            Either.Left(Failure.ServerError())
        }
    }
}