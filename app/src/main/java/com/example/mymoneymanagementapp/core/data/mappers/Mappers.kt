package com.example.mymoneymanagementapp.core.data.mappers

import com.example.mymoneymanagementapp.core.data.source.local.entities.ActivityEntity
import com.example.mymoneymanagementapp.core.data.source.local.entities.UserEntity
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.models.UserModel

fun ActivityEntity.mapToDomain(): ActivityModel = ActivityModel(
    id = id,
    activityName = activityName,
    amount = amount,
    date = date,
    isExpense = isExpense
)

fun ActivityModel.mapToEntity(): ActivityEntity = ActivityEntity(
    id = id,
    activityName = activityName,
    amount = amount,
    date = date,
    isExpense = isExpense
)

fun mappp(activityEntity: ActivityEntity): ActivityModel = ActivityModel(
    id = activityEntity.id,
    activityName = activityEntity.activityName,
    amount = activityEntity.amount,
    date = activityEntity.date,
    isExpense = activityEntity.isExpense
)