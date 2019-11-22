package es.sarascript.examenandroid

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val title: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String
)
