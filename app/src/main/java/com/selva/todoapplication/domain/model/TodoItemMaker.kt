package com.selva.todoapplication.domain.model

import com.selva.todoapplication.data.local.model.Todo

fun List<Todo>.toTodoItems(): List<TodoItem> {
    return map {
        TodoItem(
            id = it.id,
            isDone = it.isDone,
            title = it.title
        )
    }
}

fun TodoItem.toTodo(): Todo {
    return Todo(
        id = id,
        isDone = isDone,
        title = title
    )
}