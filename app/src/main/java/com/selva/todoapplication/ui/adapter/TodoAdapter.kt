package com.selva.todoapplication.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.selva.todoapplication.databinding.TodoViewHolderBinding
import com.selva.todoapplication.domain.model.TodoItem
import com.selva.todoapplication.ui.listener.onTodoClickListener

class TodoAdapter(
    private val eventClickListener: onTodoClickListener
) : RecyclerView.Adapter<TodoViewHolder>() {

    private val todoItems = mutableListOf<TodoItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun replaceItems(todoItems: List<TodoItem>) {
        this.todoItems.clear()
        this.todoItems.addAll(todoItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            TodoViewHolderBinding.inflate(LayoutInflater.from(parent.context), null, false)
        )
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoItems[position], eventClickListener)
        holder.binding.executePendingBindings()
    }
}