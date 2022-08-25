package com.example.mymoneymanagementapp.ui.features.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoneymanagementapp.core.domain.Resource
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.usecases.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class HomeViewModel @Inject constructor (private val useCase: HomeUseCase) : ViewModel() {

    private val _getAllActivities = mutableStateOf<List<ActivityModel>>(emptyList())
    val getAllActivities = _getAllActivities

    private val _getTotalAmount = mutableStateOf(0L)
    val getTotalAmount = _getTotalAmount

    private val _getTotalExpense = mutableStateOf(0L)
    val getTotalExpense = _getTotalExpense
    
    private val _getTotalIncome = mutableStateOf(0L)
    val getTotalIncome = _getTotalIncome

    private fun getAllActivities() = viewModelScope.launch {
        useCase.getAllActivities().collectLatest {
            _getAllActivities.value = it
        }
    }
    private fun getTotalAmount() = viewModelScope.launch {
        try {
            useCase.getTotalAmount().collectLatest { amount ->
                Log.d("ViewModel_Amount: ", amount.toString())
                _getTotalAmount.value = amount
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun getTotalIncome() = viewModelScope.launch {
        try {
            useCase.getTotalIncome().collectLatest { income ->
                Log.d("ViewModel_Income: ", income.toString())
                _getTotalIncome.value = income
            }
        } catch (e: Exception){
            e.printStackTrace()
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
        getTotalAmount()
        getTotalIncome()
        getTotalExpense()
    }
}