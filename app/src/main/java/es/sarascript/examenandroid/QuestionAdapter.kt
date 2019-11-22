package es.sarascript.examenandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.sarascript.examenandroid.R
import es.sarascript.examenandroid.Question


class QuestionAdapter(val listView: List<Question>): RecyclerView.Adapter<QuestionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder.from(parent)
    }

    override fun getItemCount(): Int = listView.size

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = listView[position]
        holder.bind(question)
    }
}

class QuestionViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val questionTitle = view.findViewById<TextView>(R.id.questionTitle)
    val questionAnswer1 = view.findViewById<RadioButton>(R.id.questionAnswer1)
    val questionAnswer2 = view.findViewById<RadioButton>(R.id.questionAnswer2)
    val questionAnswer3 = view.findViewById<RadioButton>(R.id.questionAnswer3)
    val questionAnswer4 = view.findViewById<RadioButton>(R.id.questionAnswer4)

    fun bind(question: Question) {
        questionTitle.text = question.title
        questionAnswer1.text = question.answer1
        questionAnswer2.text = question.answer2
        questionAnswer3.text = question.answer3
        questionAnswer4.text = question.answer4
    }

    companion object { //forma de hacer métodos statics
        fun from(parent: ViewGroup): QuestionViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.question_item, parent, false)
            return QuestionViewHolder(view)
        }
    }
}

