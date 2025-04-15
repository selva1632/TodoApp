package com.selva.todoapplication.domain

import com.selva.todoapplication.data.local.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodo(): Flow<List<Todo>>
    suspend fun upsertTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
}