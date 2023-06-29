package com.example.data.repo

import com.example.data.api.ApiService
import com.example.data.extension.convertGenericToString
import com.example.data.preferences.Preference
import com.example.domain.repo.LoginRepository
import com.example.entity.module.LoginMail
import com.example.entity.module.User
import com.example.entity.viewState.ViewState

class LoginRepositoryImpl ( var apiService: ApiService,
var dataStore: Preference,
) : LoginRepository {
    override suspend fun login(userLogin: LoginMail): ViewState<User> {
        val response = apiService.getUserLogin(userLogin)
        return if (response.isSuccessful) {
            dataStore.setUser(Preference.USER_KEY, response.body().convertGenericToString())
            ViewState.Success(response.body() ?: User.emptyUser())
        } else {
            ViewState.Error(response.code(), response.message())
        }
    }
}