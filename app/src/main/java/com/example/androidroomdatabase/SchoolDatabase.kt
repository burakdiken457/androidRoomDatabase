package com.example.androidroomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidroomdatabase.entities.Director
import com.example.androidroomdatabase.entities.School
import com.example.androidroomdatabase.entities.Student
import com.example.androidroomdatabase.entities.Subject
import com.example.androidroomdatabase.entities.StudentAndSubjectCrossRef

@Database(
    entities = [
        Director::class,
        School::class,
        Student::class,
        Subject::class,
        StudentAndSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}