package com.example.mymoneymanagementapp.core.domain.usecases.interactors

import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.repositories.ActivityRepository
import com.example.mymoneymanagementapp.core.domain.usecases.AddActivityUseCase
import com.example.mymoneymanagementapp.core.domain.usecases.HomeUseCase
import javax.inject.Inject

class AddActivityInteractor @Inject constructor(private val repository: ActivityRepository) : AddActivityUseCase {
    override suspend fun insertActivity(activity: ActivityModel) = repository.insertActivity(activity)

    override suspend fun updateActivity(activity: ActivityModel) = repository.updateActivity(activity)

    override suspend fun deleteActivity(activity: ActivityModel) = repository.deleteActivity(activity)
}