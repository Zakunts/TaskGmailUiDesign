package com.example.domain.useCase

import com.example.domain.interactors.LoginRepositoryLoginUseCase
import com.example.domain.repo.LoginRepository
import com.example.entity.module.LoginMail
import com.example.entity.module.User
import com.example.entity.viewState.ViewState

class LoginRepositoryLoginUseCaseImpl(private val repository: LoginRepository) :
    LoginRepositoryLoginUseCase {
    override suspend fun login(userLogin: LoginMail): ViewState<User> = repository.login(userLogin)

}
