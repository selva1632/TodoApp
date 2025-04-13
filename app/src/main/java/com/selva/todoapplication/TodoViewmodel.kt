package com.selva.todoapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.selva.todoapplication.adapter.TodoItem
import com.selva.todoapplication.adapter.toTodoItems
import com.selva.todoapplication.data.local.Todo
import com.selva.todoapplication.data.local.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewmodel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {

    val todoItems: LiveData<List<TodoItem>> = repository.getTodo()
        .map { it.toTodoItems() }
        .asLiveData()

    fun upsertTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.upsertTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTodo(todo)
        }
    }

    fun updateTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTodo(todo)
        }
    }
}