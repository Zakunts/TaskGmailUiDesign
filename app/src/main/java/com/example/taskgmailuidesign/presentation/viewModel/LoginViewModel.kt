package com.example.taskgmailuidesign.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.LoginRepositoryLoginUseCase
import com.example.entity.module.LoginMail
import com.example.entity.module.User
import com.example.entity.viewState.ViewState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class  LoginViewModel(var loginRepositoryLoginUseCase: LoginRepositoryLoginUseCase) : ViewModel() {
    val errorLiveData = MutableSharedFlow<String>()
    val userLiveData = MutableSharedFlow<User>()
    fun login(login: LoginMail) {
        viewModelScope.launch {
            when (val response = loginRepositoryLoginUseCase.login(login)) {
                is ViewState.Success -> {
//                    userLiveData.value = response.data ?: User.emptyUser()
                    userLiveData.emit(response.data)
                }
                is ViewState.Error -> {
//                    errorLiveData.value = response.message
                    errorLiveData.emit(response.message)
                }
            }
        }
    }
}