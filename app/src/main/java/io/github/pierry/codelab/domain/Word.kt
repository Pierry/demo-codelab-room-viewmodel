package io.github.pierry.codelab.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "Word")
data class Word(@PrimaryKey @NonNull @ColumnInfo(name = "Word") val world: String)