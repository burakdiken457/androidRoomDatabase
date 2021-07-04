package com.example.androidroomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Manager")
data class Director(

    @PrimaryKey(autoGenerate = false)
    val directorName: String,
    val schoolName: String

)