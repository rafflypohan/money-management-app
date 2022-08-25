package com.example.mymoneymanagementapp.core.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Activity(
    val id: Int = 0,
    val activityName: String,
    val amount: Long,
    val date: String,
    val isExpense: Boolean
):Parcelable
