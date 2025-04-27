package com.selva.todoapplication.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.selva.todoapplication.databinding.TodoViewHolderBinding
import com.selva.todoapplication.domain.model.TodoItem
import com.selva.todoapplication.ui.listener.onTodoClickListener

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