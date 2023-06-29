package com.example.di

import com.example.data.preferences.Preference
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataStoreModule = module {
    factory {
        Preference(androidContext())
    }
}