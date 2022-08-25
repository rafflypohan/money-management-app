package com.example.mymoneymanagementapp.core.domain.usecases.interactors

import com.example.mymoneymanagementapp.core.data.source.local.entities.ActivityEntity
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.repositories.ActivityRepository
import com.example.mymoneymanagementapp.core.domain.usecases.DetailActivityUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailActivityInteractor @Inject constructor (private val activityRepository: ActivityRepository): DetailActivityUseCase {
    override fun getActivityById(id: Int): Flow<ActivityModel> = activityRepository.getActivityById(id)
    override suspend fun updateActivity(activityModel: ActivityModel) = activityRepository.updateActivity(activityModel)

    override suspend fun deleteActivity(activityModel: ActivityModel) = activityRepository.deleteActivity(activityModel)
}