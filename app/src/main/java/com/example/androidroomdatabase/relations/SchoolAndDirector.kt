package com.example.androidroomdatabase.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidroomdatabase.entities.Director
import com.example.androidroomdatabase.entities.School


data class SchoolAndDirector(
    @Embedded val school: School,

    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )

    val director: Director

)