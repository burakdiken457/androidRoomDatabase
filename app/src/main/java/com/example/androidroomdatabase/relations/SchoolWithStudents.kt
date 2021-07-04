package com.example.androidroomdatabase.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidroomdatabase.entities.School
import com.example.androidroomdatabase.entities.Student


data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)