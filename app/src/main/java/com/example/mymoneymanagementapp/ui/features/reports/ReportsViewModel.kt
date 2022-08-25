package com.example.mymoneymanagementapp.ui.features.reports

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.usecases.ReportsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReportsViewModel @Inject constructor (private val useCase: ReportsUseCase): ViewModel() {
    private val _getAllActivities = mutableStateOf<List<ActivityModel>>(emptyList())
    val getAllActivities = _getAllActivities

    private val _getTotalExpense = mutableStateOf(0L)
    val getTotalExpense = _getTotalExpense

    private fun getAllActivities() = viewModelScope.launch {
        useCase.getAllActivities().collectLatest {
            _getAllActivities.value = it
        }
    }

    private fun getTotalExpense() = viewModelScope.launch {
        try {
            useCase.getTotalExpense().collectLatest { expense ->
                Log.d("ViewModel_Expense: ", expense.toString())
                _getTotalExpense.value = expense
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    init {
        getAllActivities()
        getTotalExpense()
    }
}