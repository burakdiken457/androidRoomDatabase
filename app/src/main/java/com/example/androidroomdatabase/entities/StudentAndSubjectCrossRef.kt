package com.example.androidroomdatabase.entities

import androidx.room.Entity

@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentAndSubjectCrossRef(
    val studentName: String,
    val subjectName: String
)