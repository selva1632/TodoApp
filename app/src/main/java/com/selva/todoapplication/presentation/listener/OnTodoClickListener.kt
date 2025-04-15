package com.selva.todoapplication.presentation.listener

import com.selva.todoapplication.domain.model.TodoItem

interface onTodoClickListener {
    fun onClickDone(todoItem: TodoItem, isChecked: Boolean)
    fun onClickDelete(todoItem: TodoItem)
}