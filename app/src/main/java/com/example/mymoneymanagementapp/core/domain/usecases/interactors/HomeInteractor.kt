package com.example.mymoneymanagementapp.core.domain.usecases.interactors

import com.example.mymoneymanagementapp.core.data.source.local.entities.UserEntity
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.repositories.ActivityRepository
import com.example.mymoneymanagementapp.core.domain.repositories.UserRepository
import com.example.mymoneymanagementapp.core.domain.usecases.HomeUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeInteractor @Inject constructor (private val activityRepository: ActivityRepository, private val userRepository: UserRepository): HomeUseCase {
    override fun getAllActivities(): Flow<List<ActivityModel>> = activityRepository.getAllActivities()

    override fun getActivityDetail(id: Int): Flow<ActivityModel> = activityRepository.getActivityById(id)

    override fun getTotalAmount(): Flow<Long> = activityRepository.getTotalAmount()

    override fun getTotalExpense(): Flow<Long> = activityRepository.getTotalExpense()

    override fun getTotalIncome(): Flow<Long> = activityRepository.getTotalIncome()
    override fun getUsername(id: Int) = userRepository.getUsername(id)

    override fun getBalance(id: Int) = userRepository.getBalance(id)

    override suspend fun updateBalance(userEntity: UserEntity) = userRepository.updateBalance(userEntity)

}