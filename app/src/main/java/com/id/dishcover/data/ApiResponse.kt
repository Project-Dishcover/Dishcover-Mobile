package com.id.dishcover.data


sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val error: String): ApiResponse<Nothing>()
}