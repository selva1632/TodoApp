package com.selva.todoapplication.data.repository

import com.selva.todoapplication.data.local.model.Todo
import com.selva.todoapplication.data.local.dao.TodoDao
import com.selva.todoapplication.domain.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val dao: TodoDao
): TodoRepository {
    override fun getTodo(): Flow<List<Todo>> {
        return dao.getTodo()
    }

    override suspend fun upsertTodo(todo: Todo) {
        dao.upsertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }

    override suspend fun updateTodo(todo: Todo) {
        dao.upsertTodo(todo)
    }
}