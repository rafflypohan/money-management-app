package com.example.mymoneymanagementapp.core.domain.models

data class ActivityModel(
    var id: Int = 0,
    val activityName: String,
    val amount: Long,
    val date: String,
    val isExpense: Boolean
)
