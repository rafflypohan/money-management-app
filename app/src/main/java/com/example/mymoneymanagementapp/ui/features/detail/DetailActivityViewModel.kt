package com.example.mymoneymanagementapp.ui.features.detail

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.usecases.DetailActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailActivityViewModel @Inject constructor(private val detailActivityUseCase: DetailActivityUseCase) :
    ViewModel() {

    fun updateActivity(activityModel: ActivityModel) = viewModelScope.launch {
        try {
            detailActivityUseCase.updateActivity(activityModel)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun deleteActivity(activityModel: ActivityModel) = viewModelScope.launch {
        try {
            detailActivityUseCase.deleteActivity(activityModel)
            Log.d("Detail: ", "Delete Success")
        } catch (e: Exception) {
            Log.d("Detail: ", "Delete Failed ($e)")
            e.printStackTrace()
        }
    }


    fun getActivityById(id: Int) = channelFlow {
        detailActivityUseCase.getActivityById(id).collectLatest {
            send(it)
        }
    }
}