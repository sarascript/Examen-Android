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
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

        private lateinit var questionList: RecyclerView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val service = RetrofitFactory.makeRetrofitService()
            CoroutineScope(Dispatchers.IO).launch {
                val response = service.getPosts()
                withContext(Dispatchers.Main) {
                    try {
                        if (response.isSuccessful) {
                            response.body();
                            //Do something with response e.g show to the UI.
                            val questionList = (1..5).map {
                                Question(
                                    title = response.body(results[$it].question),
                                    answer1 = response.body(results[$it].correct_answer),
                                    answer2 = response.body(results[$it].incorrect_answers[0]),
                                    answer3 = response.body(results[$it].incorrect_answers[1]),
                                    answer4 = response.body(results[$it].incorrect_answers[2])
                                )
                            }
                        } else {
                            toast("Error: ${response.code()}")
                        }
                    } catch (e: HttpException) {
                        toast("Exception ${e.message}")
                    } catch (e: Throwable) {
                        toast("Ooops: Something else went wrong")
                    }
                }
            }

            question_list.layoutManager = LinearLayoutManager(this)
            question_list.adapter = QuestionAdapter(questionList)
            question_list.setHasFixedSize(true)

            //val questionsDao = DatabaseFactory.get(this.applicationContext).questionsDao()
            //CoroutineScope(Dispatchers.IO).launch {
              //  val question = Question(title = "Question 1", answer1 = "Answer 1", answer2 = "Answer 2", answer3 = "Answer 3", answer4 = "Answer 4")
                //questionsDao.insertAll(question)

                //val questions = questionsDao.getAll()
                //withContext(Dispatchers.Main) {
                  //  Log.e("MainActivity", questions.toString())
              //  }
            //}

        }
    }
