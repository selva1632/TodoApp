package com.selva.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.selva.todoapplication.data.local.dao.TodoDao
import com.selva.todoapplication.data.local.database.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(todoDatabase: TodoDatabase): TodoDao {
        return todoDatabase.dao
    }
}