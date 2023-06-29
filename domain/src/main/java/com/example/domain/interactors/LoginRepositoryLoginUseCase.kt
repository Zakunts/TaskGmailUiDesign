package com.example.domain.interactors

import com.example.entity.module.LoginMail
import com.example.entity.module.User
import com.example.entity.viewState.ViewState

interface LoginRepositoryLoginUseCase {
    suspend fun login(userLogin: LoginMail): ViewState<User>
}