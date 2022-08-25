package com.example.mymoneymanagementapp.core.domain.usecases

import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import kotlinx.coroutines.flow.Flow

interface ReportsUseCase {
    fun getAllActivities(): Flow<List<ActivityModel>>
    fun getTotalExpense(): Flow<Long>
}