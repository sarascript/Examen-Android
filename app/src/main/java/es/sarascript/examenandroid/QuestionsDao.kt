package es.sarascript.examenandroid

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionsDao {
    @Query("SELECT * FROM questions")
    fun getAll(): List<Question>

    @Query("SELECT * FROM questions WHERE id IN (:questionsIds)")
    fun loadAllByIds(questionsIds: IntArray): List<Question>

    @Insert
    fun insertAll(vararg questions: Question)

    @Delete
    fun delete(questions: Question)
}