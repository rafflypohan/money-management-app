package com.example.mymoneymanagementapp.ui.features.addActivity

import androidx.lifecycle.ViewModel
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.core.domain.usecases.AddActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface IAddActivityViewModel {
     suspend fun insertActivity(activity: ActivityModel)
     suspend fun updateActivity(activity: ActivityModel)
     suspend fun deleteActivity(activity: ActivityModel)
}

@HiltViewModel
class AddActivityViewModel @Inject constructor(private val useCase: AddActivityUseCase) : ViewModel(), IAddActivityViewModel {
     override suspend fun insertActivity(activity: ActivityModel) = useCase.insertActivity(activity)
     override suspend fun updateActivity(activity: ActivityModel) = useCase.updateActivity(activity)
     override suspend fun deleteActivity(activity: ActivityModel) = useCase.deleteActivity(activity)
}

class AddActivityViewModelPreview(): IAddActivityViewModel{
     override suspend fun insertActivity(activity: ActivityModel) {
          TODO("Not yet implemented")
     }

     override suspend fun updateActivity(activity: ActivityModel) {
          TODO("Not yet implemented")
     }

     override suspend fun deleteActivity(activity: ActivityModel) {
          TODO("Not yet implemented")
     }

}