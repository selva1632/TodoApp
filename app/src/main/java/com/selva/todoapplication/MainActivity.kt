package com.selva.todoapplication

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.selva.todoapplication.presentation.adapter.TodoAdapter
import com.selva.todoapplication.domain.model.TodoItem
import com.selva.todoapplication.presentation.listener.onTodoClickListener
import com.selva.todoapplication.domain.model.toTodo
import com.selva.todoapplication.data.local.model.Todo
import com.selva.todoapplication.databinding.ActivityMainBinding
import com.selva.todoapplication.presentation.viewmodel.TodoViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewmodel: TodoViewmodel by viewModels()

    private val todoAdapter by lazy {
        TodoAdapter(eventListener)
    }

    private val eventListener by lazy {
        object : onTodoClickListener {
            override fun onClickDone(todoItem: TodoItem, isChecked: Boolean) {
                viewmodel.updateTodo(todoItem.toTodo().copy(isDone = isChecked))
            }

            override fun onClickDelete(todoItem: TodoItem) {
                viewmodel.deleteTodo(todoItem.toTodo())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        with(binding) {
            lifecycleOwner = this@MainActivity
            vm = viewmodel
            todoRecyclerview.adapter = todoAdapter
            addTaskButton.setOnClickListener { showAddTodoDialog() }
        }
    }

    private fun showAddTodoDialog() {
        val editText = EditText(this).apply {
            hint = "Enter todo"
            inputType = InputType.TYPE_CLASS_TEXT
            setPadding(32, 32, 32, 32)
        }

        AlertDialog.Builder(this)
            .setTitle("Add Todo")
            .setView(editText)
            .setPositiveButton("Add") { _, _ ->
                val text = editText.text.toString().trim()
                if (text.isNotEmpty()) {
                    val todo = Todo(title = text, isDone = false)
                    viewmodel.upsertTodo(todo)
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}