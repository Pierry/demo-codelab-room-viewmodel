package io.github.pierry.codelab.core

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import io.github.pierry.codelab.core.dao.IWordDao
import io.github.pierry.codelab.domain.Word


@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

  abstract fun wordDao(): IWordDao

  companion object {

    @Volatile
    private var INSTANCE: WordRoomDatabase? = null

    fun getDatabase(context: Context): WordRoomDatabase {
      if (INSTANCE == null) {
        synchronized(WordRoomDatabase::class) {
          if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                    WordRoomDatabase::class.java, "word_database").build()
          }
        }
      }
      return INSTANCE!!
    }
  }

}
