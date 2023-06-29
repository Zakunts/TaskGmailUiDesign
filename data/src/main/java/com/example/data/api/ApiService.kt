package com.example.data.api

import com.example.entity.module.LoginMail
import com.example.entity.module.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun getUserLogin(@Body login: LoginMail): Response<User>




}