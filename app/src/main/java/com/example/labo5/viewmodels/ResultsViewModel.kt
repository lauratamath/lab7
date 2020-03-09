package com.example.labo5.viewmodels
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultsViewModel: ViewModel(){
    var rating = MutableLiveData<Float>()
    var quantity = 0
    var answers = MutableLiveData<ArrayList<String>>()
    var answersList = ArrayList<String>()

    init {
        rating.value = 0.0F
    }
    //Setters
    fun setRating(actualRating: Float){
        val actualQuantity = quantity + 1
        val actualRate = (getSurveyRating().value!! + actualRating)/actualQuantity


        rating.value = actualRate
        quantity = actualQuantity
        answers.value = answersList
        Log.i("RatingViewModel", "Rating" + actualRate)
    }
    fun setAnswers(answer: String){
        answersList.add(answer)
    }
    //Getters
    fun getSurveyRating(): MutableLiveData<Float>{
        return rating
    }
    fun getSurveyQuantity(): Int{
        return quantity
    }

}
