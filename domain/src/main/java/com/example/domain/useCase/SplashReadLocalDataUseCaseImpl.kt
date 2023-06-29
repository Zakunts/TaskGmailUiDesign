package com.example.domain.useCase

import com.example.domain.interactors.SplashReadLocalDataUseCase
import com.example.domain.repo.SplashRepository

class SplashReadLocalDataUseCaseImpl(private val repository: SplashRepository) :
    SplashReadLocalDataUseCase {
    override suspend fun readLocalData(): Boolean = repository.readLocalData()

}