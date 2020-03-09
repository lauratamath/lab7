package com.example.labo5.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.labo5.R

//Entity class for poll table
@Entity(tableName = "answer_table")
class Answer{
    //Allows android to manage IDs
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "poll_id")
    var poll_id: Int = 0 //Poll id

    @ColumnInfo(name = "question_id")
    var question_id: Int = 0 //Question id

    @ColumnInfo(name = "answer_text")
    var answer_text: String = "" //Answer for strings

    @ColumnInfo(name = "answer_number")
    var answer_number: Float = 0.0f //Answer for rating/numbers

    @ColumnInfo(name = "questions_answered")
    var question: String = "" //Question answered

    @ColumnInfo(name = "rating_image")
    var ratingImage: Int = 0 //Rating image

    //For String questions
    constructor(poll_id:Int, question_id: Int, text:String) {
        this.poll_id = poll_id
        this.question_id = question_id
        this.answer_text = text
    }
    //For int questions
    constructor(poll_id:Int, question_id: Int, number:Float) {
        this.poll_id = poll_id
        this.question_id = question_id
        this.answer_number = number
        //Automatically setting the rating star image depending
        //on the answer gave
        if (this.answer_number == 0.0f || this.answer_number < 1.0f){
            ratingImage = R.drawable.zerostars
        } else if (this.answer_number == 1.0f || this.answer_number < 2.0f){
            ratingImage = R.drawable.onestar
        } else if (this.answer_number == 2.0f || this.answer_number < 3.0f){
            ratingImage = R.drawable.twostars
        } else if (this.answer_number == 3.0f || this.answer_number < 4.0f ){
            ratingImage = R.drawable.threestars
        } else if(this.answer_number == 4.0f || this.answer_number < 5.0f) {
            ratingImage = R.drawable.fourstars
        } else {
            ratingImage = R.drawable.fivestars
        }
    }
    //For cards
    constructor(actual_survey:Int, actual_answer:String, actual_question:String, actual_image:Int){
        this.poll_id = actual_survey
        this.answer_text = actual_answer
        this.question = actual_question
        this.ratingImage = actual_image
    }
}

