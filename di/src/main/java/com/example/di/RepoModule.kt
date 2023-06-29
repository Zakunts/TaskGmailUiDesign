package com.example.di

import com.example.data.repo.LoginRepositoryImpl
import com.example.data.repo.SplashRepositoryImpl
import com.example.domain.repo.LoginRepository
import com.example.domain.repo.SplashRepository
import org.koin.dsl.module

val repoModule = module {
    factory<LoginRepository> { LoginRepositoryImpl(get(), get()) }
    factory<SplashRepository> { SplashRepositoryImpl(get()) }

}