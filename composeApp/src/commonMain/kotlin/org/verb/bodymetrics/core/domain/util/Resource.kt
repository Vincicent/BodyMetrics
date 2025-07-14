package org.verb.bodymetrics.core.domain.util

sealed interface Resource<out T, out E: Throwable> {
    data class Success<T>(val data: T): Resource<T, Nothing>
    data class Error<E: Throwable>(val throwable: Throwable): Resource<Nothing, E>
}