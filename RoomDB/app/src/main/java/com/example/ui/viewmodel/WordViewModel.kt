package com.example.ui.viewmodel

import androidx.lifecycle.*
import com.example.data.model.Word
import com.example.data.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}