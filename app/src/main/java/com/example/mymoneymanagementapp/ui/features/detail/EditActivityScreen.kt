package com.example.mymoneymanagementapp.ui.features.detail

import android.util.Log
import android.widget.Space
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.ui.components.AddEditForm
import com.example.mymoneymanagementapp.ui.components.TopAppBar
import com.example.mymoneymanagementapp.ui.routes.Destinations
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme
import com.example.mymoneymanagementapp.utils.formatDateToString
import com.example.mymoneymanagementapp.utils.formatStringToDate
import com.example.mymoneymanagementapp.utils.getCurrentDate
import kotlinx.coroutines.launch
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditActivityScreen(
    modifier: Modifier = Modifier,
    activityId: Int?,
    detailActivityViewModel: DetailActivityViewModel = hiltViewModel(),
    navigateTo: (String) -> Unit
) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher
    val activity by detailActivityViewModel.getActivityById(activityId!!)
        .collectAsState(initial = ActivityModel(0, "", 0, "", true))
    val mId = remember { mutableStateOf(activity.id) }
    val mActivityName = remember { mutableStateOf(activity.activityName) }
    val mAmount = remember { mutableStateOf(activity.amount.toString()) }
    val mSelectedDate = remember { mutableStateOf(activity.date.formatStringToDate()) }
    val mIsExpense = remember { mutableStateOf(activity.isExpense) }
    Log.d("Edit Screen 7: ", "${activity.isExpense} | ${mIsExpense.value}")
    if (activity.id != 0) {
//        LaunchedEffect(Unit) {
            mId.value = activity.id
            mActivityName.value = activity.activityName
            mAmount.value = activity.amount.toString()
            mSelectedDate.value = activity.date.formatStringToDate()
            mIsExpense.value = activity.isExpense
//        }

        Log.d("Edit Screen 8: ", "${activity.isExpense} | ${mIsExpense.value}")

        Scaffold(
            topBar = {
                TopAppBar(
                    onBackPress = { dispatcher.onBackPressed() },
                    modifier = modifier,
                    title = "Edit Activity"
                )
            }
        ) { innerPadding ->
            Box(modifier = modifier.padding(innerPadding)) {
                EditActivityContent(
                    activityId = mId.value,
                    activityName = mActivityName,
                    amount = mAmount,
                    date = mSelectedDate,
                    isExpense = mIsExpense,
                    detailActivityViewModel = detailActivityViewModel,
                    navigateTo = {
                        navigateTo(Destinations.HOME_ROUTE)
                    }
                )
            }
        }
    }
}

@Composable
fun EditActivityContent(
    activityId: Int,
    activityName: MutableState<String>,
    amount: MutableState<String>,
    date: MutableState<Date>,
    isExpense: MutableState<Boolean>,
    detailActivityViewModel: DetailActivityViewModel,
    navigateTo: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    Log.d(
        "Edit Screen 3: ",
        "values: id - ${activityId}, name - ${activityName.value}, amount - ${amount.value}, date: - ${date.value}, isExpense - ${isExpense.value}"
    )
    Column {
        AddEditForm(
            activityName = activityName,
            amount = amount,
            selectedDate = date,
            isExpense = isExpense
        ) {
            coroutineScope.launch {
                detailActivityViewModel.updateActivity(
                    ActivityModel(
                        id = activityId,
                        activityName = activityName.value,
                        amount = if (isExpense.value) -amount.value.toLong() else amount.value.toLong(),
                        date = date.value.formatDateToString(),
                        isExpense = isExpense.value
                    )
                ).invokeOnCompletion {
                    navigateTo()
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewEditActivityScreen() {
    MyMoneyManagementAppTheme {

    }
}