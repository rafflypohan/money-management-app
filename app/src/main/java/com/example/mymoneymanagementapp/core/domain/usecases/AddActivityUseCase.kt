package com.example.mymoneymanagementapp.core.domain.usecases

import com.example.mymoneymanagementapp.core.domain.models.ActivityModel

interface AddActivityUseCase {
    suspend fun insertActivity(activity: ActivityModel)
    suspend fun updateActivity(activity: ActivityModel)
    suspend fun deleteActivity(activity: ActivityModel)
}