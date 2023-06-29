package com.example.domain.interactors

interface SplashReadLocalDataUseCase {
    suspend fun readLocalData(): Boolean
}