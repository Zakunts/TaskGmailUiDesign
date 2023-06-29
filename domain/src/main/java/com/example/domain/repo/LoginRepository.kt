package com.example.domain.repo

import com.example.entity.module.LoginMail
import com.example.entity.module.User
import com.example.entity.viewState.ViewState


interface LoginRepository {
    suspend fun login(userLogin: LoginMail): ViewState<User>
}