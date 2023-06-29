package com.example.data.repo

import com.example.data.preferences.Preference
import com.example.domain.repo.SplashRepository

class SplashRepositoryImpl(val datastore:Preference) :SplashRepository{
    override suspend fun readLocalData(): Boolean = !datastore.getUser(Preference.USER_KEY).isNullOrEmpty()

}