package es.sarascript.examenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.sarascript.examenandroid.Question
import es.sarascript.examenandroid.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

        private lateinit var questionList: RecyclerView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val questionList = (1..5).map {
                Question(
                    title = "Question $it",
                    answer1 = "Answer $it",
                    answer2 = "Answer $it",
                    answer3 = "Answer $it",
                    answer4 = "Answer $it"
                )
            }


            question_list.layoutManager = LinearLayoutManager(this)
            question_list.adapter = QuestionAdapter(questionList)
            question_list.setHasFixedSize(true)

            val questionsDao = DatabaseFactory.get(this.applicationContext).questionsDao()
            CoroutineScope(Dispatchers.IO).launch {
                val question = Question(title = "Question 1", answer1 = "Answer 1", answer2 = "Answer 2", answer3 = "Answer 3", answer4 = "Answer 4")
                questionsDao.insertAll(question)

                val questions = questionsDao.getAll()
                withContext(Dispatchers.Main) {
                    Log.e("MainActivity", questions.toString())
                }
            }

        }
    }
