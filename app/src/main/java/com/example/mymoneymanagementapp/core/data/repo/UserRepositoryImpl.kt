package com.example.mymoneymanagementapp.core.data.repo

import com.example.mymoneymanagementapp.core.data.source.local.LocalDataSource
import com.example.mymoneymanagementapp.core.data.source.local.entities.UserEntity
import com.example.mymoneymanagementapp.core.domain.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val localDataSource: LocalDataSource) :
    UserRepository {
    override fun getUsername(id: Int): Flow<String> = localDataSource.getUsername(id)

    override fun getBalance(id: Int): Flow<Long> = localDataSource.getBalance(id)

    override suspend fun insertUsername(userEntity: UserEntity) =
        localDataSource.insertUsername(userEntity)

    override suspend fun insertBalance(userEntity: UserEntity) =
        localDataSource.insertBalance(userEntity)

    override suspend fun updateBalance(userEntity: UserEntity) =
        localDataSource.updateBalance(userEntity)

}