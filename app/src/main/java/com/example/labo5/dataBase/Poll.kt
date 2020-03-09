//Table on SQLite
package com.example.labo5.dataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

//Entity class for poll table
@Entity(tableName = "poll_table")
data class Poll(
    //Allows android to manage IDs
    @PrimaryKey(autoGenerate = true)
    var questionId: Int = 0,
    @ColumnInfo(name = "creation_date")
    val create_date: String = Calendar.getInstance().time.toString() //Creation date

)
