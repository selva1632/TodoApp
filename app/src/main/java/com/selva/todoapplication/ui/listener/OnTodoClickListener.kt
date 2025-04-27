package com.selva.todoapplication.ui.listener

import com.selva.todoapplication.domain.model.TodoItem

interface onTodoClickListener {
    fun onClickDone(todoItem: TodoItem, isChecked: Boolean)
    fun onClickDelete(todoItem: TodoItem)
}