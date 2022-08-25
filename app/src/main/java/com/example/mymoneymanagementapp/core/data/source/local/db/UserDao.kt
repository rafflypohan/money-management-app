package com.example.mymoneymanagementapp.core.data.source.local.db

import androidx.room.*
import com.example.mymoneymanagementapp.core.data.source.local.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT username FROM tb_user WHERE id = :id")
    fun getUsername(id: Int): Flow<String>

    @Query("SELECT balance FROM tb_user WHERE id = :id")
    fun getBalance(id: Int): Flow<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsername(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBalance(userEntity: UserEntity)

    @Update
    suspend fun updateBalance(userEntity: UserEntity)
}