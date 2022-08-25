package com.example.mymoneymanagementapp.core.domain.repositories

import com.example.mymoneymanagementapp.core.data.source.local.entities.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsername(id: Int): Flow<String>
    fun getBalance(id: Int): Flow<Long>
    suspend fun insertUsername(userEntity: UserEntity)
    suspend fun insertBalance(userEntity: UserEntity)
    suspend fun updateBalance(userEntity: UserEntity)
}