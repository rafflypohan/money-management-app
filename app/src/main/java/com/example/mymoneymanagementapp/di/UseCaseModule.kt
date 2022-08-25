package com.example.mymoneymanagementapp.di

import com.example.mymoneymanagementapp.core.domain.usecases.AddActivityUseCase
import com.example.mymoneymanagementapp.core.domain.usecases.DetailActivityUseCase
import com.example.mymoneymanagementapp.core.domain.usecases.HomeUseCase
import com.example.mymoneymanagementapp.core.domain.usecases.ReportsUseCase
import com.example.mymoneymanagementapp.core.domain.usecases.interactors.AddActivityInteractor
import com.example.mymoneymanagementapp.core.domain.usecases.interactors.DetailActivityInteractor
import com.example.mymoneymanagementapp.core.domain.usecases.interactors.HomeInteractor
import com.example.mymoneymanagementapp.core.domain.usecases.interactors.ReportsInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract fun bindHomeUseCase(
        homeInteractor: HomeInteractor
    ): HomeUseCase

    @Binds
    @Singleton
    abstract fun bindAddActivityUseCase(
        addActivityInteractor: AddActivityInteractor
    ): AddActivityUseCase

    @Binds
    @Singleton
    abstract fun bindDetailActivityUseCase(
        detailActivityInteractor: DetailActivityInteractor
    ): DetailActivityUseCase

    @Binds
    @Singleton
    abstract fun bindReportsUseCase(
        reportsInteractor: ReportsInteractor
    ): ReportsUseCase
}