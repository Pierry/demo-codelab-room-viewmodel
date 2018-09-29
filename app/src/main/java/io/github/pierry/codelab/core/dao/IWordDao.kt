package io.github.pierry.codelab.core.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.github.pierry.codelab.domain.Word

@Dao
interface IWordDao {

  @Insert
  fun insert(note: Word)

  @Query("DELETE FROM Word")
  fun deleteAll()

  @Query("SELECT * FROM Word ORDER BY word asc")
  fun getAllWords(): LiveData<List<Word>>

}
