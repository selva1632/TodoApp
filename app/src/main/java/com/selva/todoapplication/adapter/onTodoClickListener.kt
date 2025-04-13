package com.selva.todoapplication.adapter

interface onTodoClickListener {
    fun onClickDone(todoItem: TodoItem, isChecked: Boolean)
    fun onClickDelete(todoItem: TodoItem)
}