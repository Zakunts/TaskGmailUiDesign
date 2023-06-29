package com.example.taskgmailuidesign.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.SplashReadLocalDataUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class SplashViewMode(var splashReadLocalDataUseCase: SplashReadLocalDataUseCase) : ViewModel() {
   private val _autoLogin = MutableSharedFlow<Boolean>()
    val autoLogin = _autoLogin
    init {
        viewModelScope.launch {
//            _autoLogin.value = repository.readLocalData()
            _autoLogin.emit(splashReadLocalDataUseCase.readLocalData())
        }
    }

}