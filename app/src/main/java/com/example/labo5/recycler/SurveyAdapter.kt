package com.example.labo5.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.labo5.R
import com.example.labo5.dataBase.Answer
import kotlinx.android.synthetic.main.list_results.view.*

class SurveyAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var item: List<Answer> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AnswerViewHolder(
            LayoutInflater.from(parent.context!!).inflate(R.layout.list_results, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is AnswerViewHolder -> {
                holder.bind(item.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun submitList(answerList: List<Answer>){
        item = answerList
    }

    class AnswerViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        var rating_image = itemView.ratingImage
        val survey_number = itemView.surveyNumber
        val survey_answer = itemView.surveyAnswer
        val survey_question = itemView.surveyQuestion

        fun bind(answer: Answer){
            survey_number.setText(answer.poll_id.toString())
            survey_question.setText(answer.question)
            survey_answer.setText(answer.answer_text)

            val requestOptions = RequestOptions().placeholder(R.drawable.threestars).error(R.drawable.threestars)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(answer.ratingImage)
                .into(rating_image)


        }
    }


}