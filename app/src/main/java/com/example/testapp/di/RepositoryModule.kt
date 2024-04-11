package com.example.testapp.di

import com.example.testapp.data.repository.local.DatabaseRepository
import com.example.testapp.data.repository.local.DatabaseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providesMoviesRepositoryImpl(repositoryImpl: DatabaseRepositoryImpl): DatabaseRepository
}