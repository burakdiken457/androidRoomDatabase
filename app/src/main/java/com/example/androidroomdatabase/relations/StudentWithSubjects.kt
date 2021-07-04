package com.example.androidroomdatabase.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.androidroomdatabase.entities.Student
import com.example.androidroomdatabase.entities.StudentAndSubjectCrossRef
import com.example.androidroomdatabase.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentAndSubjectCrossRef::class)
    )
    val subject: List<Subject>
)