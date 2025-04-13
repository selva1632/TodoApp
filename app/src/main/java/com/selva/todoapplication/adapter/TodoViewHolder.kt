package com.selva.todoapplication.adapter

import androidx.recyclerview.widget.RecyclerView
import com.selva.todoapplication.databinding.TodoViewHolderBinding

class TodoViewHolder(val binding: TodoViewHolderBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(todoItem: TodoItem, eventListener: onTodoClickListener) {
        with(binding) {
            bindingItem = todoItem
            deleteButton.setOnClickListener {
                eventListener.onClickDelete(todoItem)
            }
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                eventListener.onClickDone(todoItem, isChecked)
            }
        }
    }
}