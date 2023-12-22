package com.id.dishcover.data.auth.request.register


data class RegisterDataRequest(
    val name: String,
    val username: String,
    val email: String,
    val password: String
)
