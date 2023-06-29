package com.example.domain.repo

interface SplashRepository {
    suspend fun readLocalData(): Boolean
}