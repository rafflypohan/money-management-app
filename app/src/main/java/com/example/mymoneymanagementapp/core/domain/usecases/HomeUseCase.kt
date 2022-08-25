package com.example.mymoneymanagementapp.core.domain.usecases

import com.example.mymoneymanagementapp.core.data.source.local.entities.UserEntity
import com.example.mymoneymanagementapp.core.domain.Resource
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    fun getAllActivities(): Flow<List<ActivityModel>>
    fun getActivityDetail(id: Int): Flow<ActivityModel>
    fun getTotalAmount(): Flow<Long>
    fun getTotalExpense(): Flow<Long>
    fun getTotalIncome(): Flow<Long>
    fun getUsername(id: Int): Flow<String>
    fun getBalance(id: Int): Flow<Long>
    suspend fun updateBalance(userEntity: UserEntity)
}