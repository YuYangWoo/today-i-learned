package com.example.data.di

import com.example.data.repository.WordRepository
import com.example.ui.viewmodel.WordViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        WordViewModel(get())
    }
}