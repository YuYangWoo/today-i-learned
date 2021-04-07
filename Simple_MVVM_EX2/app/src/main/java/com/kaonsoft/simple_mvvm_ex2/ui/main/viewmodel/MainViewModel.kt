package com.kaonsoft.simple_mvvm_ex2.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaonsoft.simple_mvvm_ex2.data.model.GithubRepositoryModel
import com.kaonsoft.simple_mvvm_ex2.data.repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val githubRepository: GithubRepository) : ViewModel() {
    private val _githubRepositories = MutableLiveData<List<GithubRepositoryModel>>()
    val githubRepositories = _githubRepositories

    fun requestGithubRepositories(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            githubRepository.getRepositories(query).let { response ->
                if(response.isSuccessful) {
                    response.body().let {
                        _githubRepositories.postValue(it!!.items)
                    }
                }
                else {

                }
            }
        }
    }

}