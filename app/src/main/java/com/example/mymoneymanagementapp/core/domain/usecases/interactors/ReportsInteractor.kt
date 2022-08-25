package com.example.mymoneymanagementapp.core.domain.usecases.interactors

import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.repositories.ActivityRepository
import com.example.mymoneymanagementapp.core.domain.usecases.ReportsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReportsInteractor @Inject constructor (private val activityRepository: ActivityRepository): ReportsUseCase {
    override fun getAllActivities(): Flow<List<ActivityModel>>  = activityRepository.getAllActivities()
    override fun getTotalExpense(): Flow<Long> = activityRepository.getTotalExpense()
}