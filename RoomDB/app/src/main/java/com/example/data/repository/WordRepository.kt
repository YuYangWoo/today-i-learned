package com.example.data.repository

import androidx.annotation.WorkerThread
import com.example.data.model.Word
import com.example.data.model.WordDao

class WordRepository(private val wordDao: WordDao) {
    val allWords = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}