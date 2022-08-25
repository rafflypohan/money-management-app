package com.example.mymoneymanagementapp.ui.features.addActivity

import android.annotation.SuppressLint
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.ui.components.AddEditForm
import com.example.mymoneymanagementapp.ui.components.TopAppBar
import com.example.mymoneymanagementapp.ui.routes.Destinations
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme
import com.example.mymoneymanagementapp.utils.formatDateToString
import com.example.mymoneymanagementapp.utils.getCurrentDate
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddActivityScreen(
    modifier: Modifier = Modifier,
    navigateTo: (String) -> Unit = {},
    addActivityViewModel: AddActivityViewModel = hiltViewModel()
) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher
    Scaffold(
        topBar = {
            TopAppBar(
                onBackPress = { dispatcher.onBackPressed() },
                modifier = modifier,
                title = "Add Activity"
            )
        }
    ) { innerPadding ->
        Box(modifier = modifier.padding(innerPadding)) {
            AddActivityContent(addActivityViewModel = addActivityViewModel, navigateTo = navigateTo)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddActivityContent(
    modifier: Modifier = Modifier,
    navigateTo: (String) -> Unit,
    addActivityViewModel: AddActivityViewModel
) {
    val activityName = remember {
        mutableStateOf("")
    }
    val amount = remember {
        mutableStateOf("0")
    }
    val selectedDate = remember {
        mutableStateOf(getCurrentDate())
    }
    val isExpense = remember {
        mutableStateOf(true)
    }
    val coroutineScope = rememberCoroutineScope()
    AddEditForm(
        modifier = modifier,
        activityName = activityName,
        amount = amount,
        selectedDate = selectedDate,
        isExpense = isExpense
    ) {
        coroutineScope.launch {
            addActivityViewModel.insertActivity(
                ActivityModel(
                    activityName = activityName.value,
                    amount = if (isExpense.value) -amount.value.toLong() else amount.value.toLong(),
                    date = selectedDate.value.formatDateToString(),
                    isExpense = isExpense.value
                )
            )
        }.invokeOnCompletion {
            // TODO: Change with navigate with inclusive
            navigateTo(Destinations.HOME_ROUTE)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddActivityScreenPreview() {
    MyMoneyManagementAppTheme {
        AddActivityScreen()
    }
}
