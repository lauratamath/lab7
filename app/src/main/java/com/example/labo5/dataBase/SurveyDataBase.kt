package com.example.labo5.dataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


//Code reference: CodeAndroid
//https://www.youtube.com/channel/UCMvagHKkUlt3t_E4KxwQXXQ

val DATABASE_NAME = "SurveyDB"
val TABLE_NAME = "Survey"
val COL_ANSWER = "answer"
val COL_ID = "id"
val COL_RATING = "rating"
var COL_QUESTION = "question"

var data = ArrayList<Answer>()

class SurveyDataBase(context: Context?):SQLiteOpenHelper(context, DATABASE_NAME, null, 4){
    var actual_answer = ""
    var actual_rating = ""
    var actual_question = ""
    var actual_survey = 0
    var actual_image = 0



    //Creating table
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " +TABLE_NAME+ "(" +
                COL_ID+" INT,"+
                COL_QUESTION + " TEXT," +
                COL_ANSWER + " TEXT," +
                COL_RATING + " TEXT);"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    //Insert needed for table
    fun insert(){
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COL_ID, actual_survey)
        cv.put(COL_QUESTION, actual_question)
        cv.put(COL_ANSWER, actual_answer)
        cv.put(COL_RATING, actual_rating)



        db.insert(TABLE_NAME,null,cv)
        db.close()
    }

    //Insert int answer
    fun insertAnswerInt(answer: Answer){
        actual_rating = answer.answer_number.toString()
        actual_image = answer.ratingImage
    }
    //Insert String answer
    fun insertAnswerString(answer: Answer){
        actual_answer = answer.answer_text
    }
    //Insert actual question
    fun insertQuestion(question: String){
        actual_question = question
    }
    //Insert actual survey
    fun insertSurvey(survey: Int){
        actual_survey = survey
    }
    //Deleting table
    fun deleteSurvey(){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, null, null)
        db.close()
    }
    //Deleting answers
    fun deleteAnswers(){
        val db = this.writableDatabase
        val cv = ContentValues()
        data = ArrayList()

        cv.put(COL_ID, actual_survey)
        cv.put(COL_QUESTION, actual_question)
        cv.put(COL_RATING, "")
        cv.put(COL_ANSWER, "")

        db.insert(TABLE_NAME,null,cv)
    }

    fun addData(){
        data.add(Answer(actual_survey, actual_answer, actual_question, actual_image))
        Log.d("tamano data", "se agrega")
    }

    fun getDataAdded():ArrayList<Answer>{
        return data
    }
}