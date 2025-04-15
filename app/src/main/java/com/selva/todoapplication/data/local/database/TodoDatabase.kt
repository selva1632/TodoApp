package com.selva.todoapplication.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.selva.todoapplication.data.local.dao.TodoDao
import com.selva.todoapplication.data.local.model.Todo

@Database(
    entities = [Todo::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase: RoomDatabase() {
    abstract val dao: TodoDao
}