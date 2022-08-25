package com.example.mymoneymanagementapp.core.domain.usecases

import com.example.mymoneymanagementapp.core.data.source.local.entities.ActivityEntity
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import kotlinx.coroutines.flow.Flow

interface DetailActivityUseCase {
    fun getActivityById(id: Int): Flow<ActivityModel>
    suspend fun updateActivity(activityModel: ActivityModel)
    suspend fun deleteActivity(activityModel: ActivityModel)
}