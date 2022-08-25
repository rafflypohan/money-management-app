package com.example.mymoneymanagementapp.core.data.source.local.db

import androidx.room.*
import com.example.mymoneymanagementapp.core.data.source.local.entities.ActivityEntity
import com.example.mymoneymanagementapp.core.domain.Resource
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {
    @Query("SELECT * FROM tb_activity ORDER BY id DESC")
    fun getAllActivities(): Flow<List<ActivityEntity>>

    @Query("SELECT * FROM tb_activity WHERE id=:id")
    fun getActivityById(id: Int): Flow<ActivityEntity>

    @Query("SELECT SUM(amount) FROM tb_activity")
    fun getTotalAmount(): Flow<Long>

    @Query("SELECT SUM(amount) FROM tb_activity WHERE is_expense = 1")
    fun getTotalExpense(): Flow<Long>

    @Query("SELECT SUM(amount) FROM tb_activity WHERE is_expense = 0")
    fun getTotalIncome(): Flow<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(activity: ActivityEntity)

    @Update
    suspend fun updateActivity(activity: ActivityEntity)

    @Delete
    suspend fun deleteActivity(activity: ActivityEntity)
}