package com.example.data.di

import com.example.data.model.WordRoomDatabase
import com.example.data.repository.WordRepository
import com.example.ui.viewmodel.WordViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    val applicationScope = CoroutineScope(SupervisorJob())

    single {
       WordRoomDatabase.getDatabase(androidApplication(), applicationScope)
    }
    single {
        WordRepository(get())
    }
    single {
        get<WordRoomDatabase>().wordDao()
    }
    viewModel {
        WordViewModel(get())
    }
}