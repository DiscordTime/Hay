package br.com.hay.base

sealed class Either<out L, out R> {

    data class Left<out L>(val leftValue: L) : Either<L, Nothing>()

    data class Right<out R>(val rightValue: R) : Either<Nothing, R>()

    val isRight get() = this is Right<R>

    val isLeft get() = this is Left<L>

    fun <L> left(leftValue: L) = Either.Left(leftValue)

    fun <R> right(rightValue: R) = Either.Right(rightValue)

    fun either(functionLeft: (L) -> Any, functionRight: (R) -> Any): Any =
            when(this) {
                is Left -> functionLeft(leftValue)
                is Right -> functionRight(rightValue)
            }
}

fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}

fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> =
        when (this) {
            is Either.Left -> Either.Left(leftValue)
            is Either.Right -> fn(rightValue)
        }

fun <T, L, R> Either<L, R>.map(fn: (R) -> (T)): Either<L, T> = this.flatMap(fn.c(::right))