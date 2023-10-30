package com.cdanielvalente.androidmaster.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cdanielvalente.androidmaster.R
import com.cdanielvalente.androidmaster.todoapp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {
    private val categories = listOf(
        Business,
        Personal,
        Other
    );
    private val tasks = mutableListOf(
        Task("Prueba Business", Business),
        Task("Prueba Personal", Personal),
        Task("Prueba Other", Other),
    );

    private lateinit var rvCategories: RecyclerView;
    private lateinit var categoryAdapter: CategoriesAdapter;

    private lateinit var rvTasks: RecyclerView;
    private lateinit var tasksAdapter: TasksAdapter;

    private lateinit var fabAddTask: FloatingActionButton;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo);

        initComponent();
        initUI();
        initListeners();
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories);
        rvTasks = findViewById(R.id.rvTasks);
        fabAddTask = findViewById(R.id.fabAddTask);
    };

    private fun initUI() {
        categoryAdapter = CategoriesAdapter(categories);
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvCategories.adapter = categoryAdapter;

        tasksAdapter = TasksAdapter(tasks);
        rvTasks.layoutManager = LinearLayoutManager(this);
        rvTasks.adapter = tasksAdapter;
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this);
        dialog.setContentView(R.layout.dialog_task);
        dialog.show();
    }
}