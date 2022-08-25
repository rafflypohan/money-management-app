package com.example.mymoneymanagementapp.core.data.repo

import com.example.mymoneymanagementapp.core.data.mappers.mapToDomain
import com.example.mymoneymanagementapp.core.data.mappers.mapToEntity
import com.example.mymoneymanagementapp.core.data.mappers.mappp
import com.example.mymoneymanagementapp.core.data.source.local.LocalDataSource
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.repositories.ActivityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ActivityRepositoryImpl @Inject constructor (
    private val localDataSource: LocalDataSource
) : ActivityRepository {
    override fun getAllActivities(): Flow<List<ActivityModel>> = flow {
        localDataSource.getAllActivities().collect { listActivityEntity ->
            emit(listActivityEntity.map { it.mapToDomain() })
        }
    }

    override fun getActivityById(id: Int):Flow<ActivityModel> = flow {
        localDataSource.getActivityById(id).filterNotNull().collect { activityEntity ->
            emit(activityEntity.mapToDomain())
        }
    }

    override fun getTotalAmount(): Flow<Long> = localDataSource.getTotalAmount()

    override fun getTotalExpense(): Flow<Long> = localDataSource.getTotalExpense()

    override fun getTotalIncome(): Flow<Long> = localDataSource.getTotalIncome()

    override suspend fun insertActivity(activity: ActivityModel) = localDataSource.insertActivity(activity.mapToEntity())

    override suspend fun updateActivity(activity: ActivityModel) = localDataSource.updateActivity(activity.mapToEntity())

    override suspend fun deleteActivity(activity: ActivityModel) = localDataSource.deleteActivity(activity.mapToEntity())
}