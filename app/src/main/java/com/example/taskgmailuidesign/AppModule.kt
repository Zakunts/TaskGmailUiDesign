package com.example.taskgmailuidesign

import android.app.Application
import com.example.di.dataStoreModule
import com.example.di.repoModule
import com.example.di.useCaseModule
import com.example.taskgmailuidesign.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AppModule : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(viewModelModule,dataStoreModule,useCaseModule, repoModule)
        }
    }
}