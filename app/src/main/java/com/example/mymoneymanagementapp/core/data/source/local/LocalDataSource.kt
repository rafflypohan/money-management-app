package com.example.mymoneymanagementapp.core.data.source.local

import com.example.mymoneymanagementapp.core.data.source.local.db.ActivityDao
import com.example.mymoneymanagementapp.core.data.source.local.db.UserDao
import com.example.mymoneymanagementapp.core.data.source.local.entities.ActivityEntity
import com.example.mymoneymanagementapp.core.data.source.local.entities.UserEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor (private val activityDao: ActivityDao, private val userDao: UserDao) {
    // Activity DAO
    fun getAllActivities() = activityDao.getAllActivities()
    fun getActivityById(id: Int)= activityDao.getActivityById(id)
    fun getTotalAmount() = activityDao.getTotalAmount()
    fun getTotalExpense() = activityDao.getTotalExpense()
    fun getTotalIncome() = activityDao.getTotalIncome()
    suspend fun insertActivity(activity: ActivityEntity) = activityDao.insertActivity(activity)
    suspend fun updateActivity(activity: ActivityEntity) = activityDao.updateActivity(activity)
    suspend fun deleteActivity(activity: ActivityEntity) = activityDao.deleteActivity(activity)

    // User DAO
    fun getUsername(id: Int) = userDao.getUsername(id)
    fun getBalance(id: Int) = userDao.getBalance(id)
    suspend fun insertUsername(userEntity: UserEntity) = userDao.insertUsername(userEntity)
    suspend fun insertBalance(userEntity: UserEntity) = userDao.insertBalance(userEntity)
    suspend fun updateBalance(userEntity: UserEntity) = userDao.updateBalance(userEntity)
}