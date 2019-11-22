package es.sarascript.examenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.sarascript.examenandroid.Question
import es.sarascript.examenandroid.R
import kotlinx.android.synthetic.main.activity_main.*

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
        }
    }
