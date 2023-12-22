package com.id.dishcover.repository.model.profile



data class ProfileModel(
    val userName: String,
    val email: String,
    val photoUrl: String
) {
    companion object {
        fun emptyData() = ProfileModel(userName = "", email = "", photoUrl = "")
    }
}
