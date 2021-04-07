package com.kaonsoft.simple_mvvm_ex2.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kaonsoft.simple_mvvm_ex2.data.repository.GithubRepository

class MainViewModelFactory(private val githubRepository: GithubRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GithubRepository::class.java).newInstance(githubRepository)
    }

}