package com.selva.todoapplication.di

import com.selva.todoapplication.data.local.TodoRepository
import com.selva.todoapplication.data.local.TodoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(repository: TodoRepositoryImpl): TodoRepository
}