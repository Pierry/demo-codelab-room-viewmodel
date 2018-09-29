package io.github.pierry.codelab.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import io.github.pierry.codelab.domain.Word
import io.github.pierry.codelab.repository.WordRepository

class WordViewModel(application: Application) : AndroidViewModel(application) {

  lateinit var wordRepository : WordRepository

  init {
    wordRepository = WordRepository(application)
  }

  fun getAllWords(): LiveData<List<Word>> = wordRepository.getAllWords()

  fun insert(word: Word) = wordRepository.insert(word)

}