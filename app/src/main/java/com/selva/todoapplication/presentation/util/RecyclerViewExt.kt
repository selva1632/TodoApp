package com.selva.todoapplication.presentation.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.selva.todoapplication.domain.model.TodoItem
import com.selva.todoapplication.presentation.adapter.TodoAdapter

@BindingAdapter("bind:myTodoItems")
fun setTodoItems(todoRecyclerView: RecyclerView, todoItems: List<TodoItem>?) {
    val adapter = todoRecyclerView.adapter as? TodoAdapter
    todoItems?.let {
        adapter?.replaceItems(it)
    }
}