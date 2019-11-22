package es.sarascript.examenandroid

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Question(

    val title: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String

)
