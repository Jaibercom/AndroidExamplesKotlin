package co.edu.udea.compumovil.room.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
//    @PrimaryKey(autoGenerate = true) val id: Int,
    @PrimaryKey @ColumnInfo(name = "word") val word: String
)