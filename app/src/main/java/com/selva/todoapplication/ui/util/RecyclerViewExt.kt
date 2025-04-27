package com.selva.todoapplication.ui.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.selva.todoapplication.domain.model.TodoItem
import com.selva.todoapplication.ui.adapter.TodoAdapter

@BindingAdapter("bind:myTodoItems")
fun setTodoItems(todoRecyclerView: RecyclerView, todoItems: List<TodoItem>?) {
    val adapter = todoRecyclerView.adapter as? TodoAdapter
    todoItems?.let {
        adapter?.replaceItems(it)
    }
}