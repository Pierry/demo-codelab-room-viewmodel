package io.github.pierry.codelab.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import io.github.pierry.codelab.core.WordRoomDatabase
import io.github.pierry.codelab.core.dao.IWordDao
import io.github.pierry.codelab.domain.Word
import org.jetbrains.anko.doAsync

class WordRepository(application: Application) {

  private lateinit var mWordDao: IWordDao
  private lateinit var mAllWords: LiveData<List<Word>>

  init {
    val db: WordRoomDatabase = WordRoomDatabase.getDatabase(application)
    mWordDao = db.wordDao()
    mAllWords = mWordDao.getAllWords()
  }

  fun getAllWords(): LiveData<List<Word>> {
    return mAllWords
  }

  fun insert(word: Word) {
    doAsync { mWordDao.insert(word) }
  }

}