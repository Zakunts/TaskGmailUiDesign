package com.example.di

import com.example.domain.interactors.LoginRepositoryLoginUseCase
import com.example.domain.interactors.SplashReadLocalDataUseCase
import com.example.domain.useCase.LoginRepositoryLoginUseCaseImpl
import com.example.domain.useCase.SplashReadLocalDataUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<LoginRepositoryLoginUseCase> { LoginRepositoryLoginUseCaseImpl(get()) }

    factory<SplashReadLocalDataUseCase> { SplashReadLocalDataUseCaseImpl(get()) }

}