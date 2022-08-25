package com.example.mymoneymanagementapp.core.domain.repositories

import com.example.mymoneymanagementapp.core.data.source.local.entities.ActivityEntity
import com.example.mymoneymanagementapp.core.domain.Resource
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {
    fun getAllActivities(): Flow<List<ActivityModel>>
    fun getActivityById(id: Int): Flow<ActivityModel>
    fun getTotalAmount(): Flow<Long>
    fun getTotalExpense(): Flow<Long>
    fun getTotalIncome(): Flow<Long>
    suspend fun insertActivity(activity: ActivityModel)
    suspend fun updateActivity(activity: ActivityModel)
    suspend fun deleteActivity(activity: ActivityModel)
}