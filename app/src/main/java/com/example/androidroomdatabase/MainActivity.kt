package com.example.androidroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.androidroomdatabase.entities.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director("Sylvanas", "Undercity"),
            Director("Anduin", "Stormwind"),
            Director("Tyrande", "Darnassus")
        )

        val schools = listOf(
            School("Undercity"),
            School("Stormwind"),
            School("Darnassus")
        )

        val students = listOf(
            Student("sylvanas", 3, "Undercity"),
            Student("anduin", 1, "Stormwind"),
            Student("tyrande", 3, "Darnassus")
        )

        val subjects = listOf<Subject>(
            Subject("ateş"),
            Subject("toprak"),
            Subject("su"),
            Subject("tahta"),
            Subject("shadow"),
        )

        val studentAndSubjectCrossRef = listOf<StudentAndSubjectCrossRef>(
            StudentAndSubjectCrossRef("Sylvanas", "shadow"),
            StudentAndSubjectCrossRef("Sylvanas", "arcane"),
            StudentAndSubjectCrossRef("Anduin", "holy"),
            StudentAndSubjectCrossRef("Anduin", "shadow"),
            StudentAndSubjectCrossRef("Tyrande", "arcane"),
            StudentAndSubjectCrossRef("Tyrande", "holy"),
            StudentAndSubjectCrossRef("Tyrande", "shadow"),
        )

        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            students.forEach { dao.insertStudent(it) }
            subjects.forEach { dao.insertSubject(it) }
            studentAndSubjectCrossRef.forEach { dao.insertStudentAndSubjectCrossRef(it) }

            val schoolWithDirector = dao.getSchoolAndDirectorViaSchoolName("Undercity")
            val schoolWithStudents = dao.getSchoolWithStudentsViaSchoolName("Darnassus")
            schoolWithStudents.first().students

        }
    }
}