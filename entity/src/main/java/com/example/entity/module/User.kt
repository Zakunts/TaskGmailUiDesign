package com.example.entity.module

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("token")
    val token: String
){
    companion object{
        fun emptyUser(): User {
            return User(
                id = 0,
                phone = "",
                email = "",
                "",
                token = ""
            )
        }
    }
}
