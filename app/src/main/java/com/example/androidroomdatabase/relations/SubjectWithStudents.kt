package com.example.androidroomdatabase.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.androidroomdatabase.entities.Student
import com.example.androidroomdatabase.entities.StudentAndSubjectCrossRef
import com.example.androidroomdatabase.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentAndSubjectCrossRef::class)
    )
    val student: List<Student>
)