package br.com.hay.forgotpassword

import br.com.hay.base.Either
import br.com.hay.base.Failure
import br.com.hay.base.Logger
import br.com.hay.base.NetworkHandler
import retrofit2.Call

class ForgotPasswordRepositoryImpl(private val forgotPasswordService: ForgotPasswordService,
                          private val networkHandler: NetworkHandler,
                          private val logger: Logger) : ForgotPasswordRepository {

    override fun forgotPassword(email: String) : Either<Failure, Boolean> {
        logger.log("ForgotPasswordRepositoryImpl", Logger.Level.Debug, "Network is connected: " + networkHandler.isConnected)
        return when (networkHandler.isConnected) {
            true -> request(forgotPasswordService.forgotPassword(email), { it }, false)
            false, null -> Either.Left(Failure.NetworkConnection())
        }
    }

    private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            logger.log("ForgotPasswordRepositoryImpl", Logger.Level.Debug, response.toString())
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError())
            }
        } catch (exception: Throwable) {
            logger.log("ForgotPasswordRepositoryImpl", Logger.Level.Error, exception.message!!)
            Either.Left(Failure.ServerError())
        }
    }
}