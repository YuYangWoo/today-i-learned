package com.kaonsoft.mvvmex.module

import com.kaonsoft.mvvmex.DataModel
import com.kaonsoft.mvvmex.DataModelImpl
import com.kaonsoft.mvvmex.MainViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * 의존성 주입에 사용할 모듈 의존성 주입을 하는 실제 코드 설계도
 * factory는 공장 datamodelimpl클래스를 만들어줌
 */
var modelPart = module {
    factory<DataModel> {
        DataModelImpl()
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

var myDiModule = listOf(modelPart, viewModelPart)