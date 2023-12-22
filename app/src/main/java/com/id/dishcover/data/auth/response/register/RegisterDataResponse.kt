package com.id.dishcover.data.auth.response.register

import com.google.gson.annotations.SerializedName

data class RegisterDataResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("username")
    val username: String
)