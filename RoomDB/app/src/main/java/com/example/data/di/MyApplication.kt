package com.example.data.di

import android.app.Application
import com.example.data.model.WordRoomDatabase
import com.example.data.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    //    override fun onCreate() {
//        super.onCreate()
//        startKoin {
//            androidLogger()
//            androidContext(this@MyApplication)
//            modules(appModule)
//        }
//    }
// No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}