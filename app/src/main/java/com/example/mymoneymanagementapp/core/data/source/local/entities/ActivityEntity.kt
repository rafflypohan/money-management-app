package com.example.mymoneymanagementapp.core.data.source.local.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_activity")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @NonNull
    @ColumnInfo(name = "activity_name")
    val activityName: String,

    @NonNull
    @ColumnInfo(name = "amount")
    val amount: Long,

    @NonNull
    @ColumnInfo(name = "date")
    val date: String,

    @NonNull
    @ColumnInfo(name = "is_expense")
    val isExpense: Boolean
)