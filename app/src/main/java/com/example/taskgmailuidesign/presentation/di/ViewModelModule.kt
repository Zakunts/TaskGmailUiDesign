package com.example.taskgmailuidesign.presentation.di

import com.example.taskgmailuidesign.presentation.viewModel.LoginViewModel
import com.example.taskgmailuidesign.presentation.viewModel.SplashViewMode
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewMode(get()) }
    viewModel{ LoginViewModel(get()) }
}