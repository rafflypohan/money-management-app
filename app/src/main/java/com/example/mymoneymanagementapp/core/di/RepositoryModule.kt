package com.example.mymoneymanagementapp.core.di

import com.example.mymoneymanagementapp.core.data.repo.ActivityRepositoryImpl
import com.example.mymoneymanagementapp.core.data.repo.UserRepositoryImpl
import com.example.mymoneymanagementapp.core.domain.repositories.ActivityRepository
import com.example.mymoneymanagementapp.core.domain.repositories.UserRepository
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
    abstract fun bindActivityRepository(
        activityRepositoryImpl: ActivityRepositoryImpl
    ): ActivityRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}