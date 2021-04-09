package com.kaonsoft.simple_koin_ex1.di

import com.kaonsoft.simple_koin_ex1.MainRepository
import com.kaonsoft.simple_koin_ex1.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

    val appModule = module {
        single<MainRepository> { // 싱글 인스턴스 생성
            MainRepository()
        }
        viewModel { MainViewModel(get()) } // viewmodel에게 주입
    }
