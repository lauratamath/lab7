//Table on SQLite
package com.example.labo5.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity class for question table
@Entity(tableName = "question_table")
class Question {
    //Allows android to manage IDs
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "question_name")
    var name: String = "" //Question

    @ColumnInfo(name = "question_type")
    var type: String = "" //Question type text/number/rating

    @ColumnInfo(name = "question_default")
    var default: Boolean = true //Default question = true

    constructor(name:String, type: String, default:Boolean){
        this.name = name
        this.type = type
        this.default = default
    }

    //Getter
    fun getQuestionType(): String{
        return type
    }
}

