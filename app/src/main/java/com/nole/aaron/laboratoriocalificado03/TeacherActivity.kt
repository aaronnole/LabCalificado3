package com.nole.aaron.laboratoriocalificado03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TeacherActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var teacherAdapter: TeacherAdapter
    private lateinit var viewModel: TeacherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this).get(TeacherViewModel::class.java)
        viewModel.teachers.observe(this) { teachers ->
            teacherAdapter = TeacherAdapter(teachers)
            recyclerView.adapter = teacherAdapter
        }

        // Llama al ViewModel para obtener los datos
        viewModel.fetchTeachers()
    }
}
