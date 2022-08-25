package com.example.mymoneymanagementapp.ui.features.home

import android.annotation.SuppressLint
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymoneymanagementapp.ui.components.TopAppBar
import com.example.mymoneymanagementapp.ui.components.latestActivities.ActivitiesList
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme


// TODO: Remove Dummy
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AllActivitiesScreen(
    modifier: Modifier = Modifier,
    navigateTo: (String) -> Unit = {},
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher
    val activities by homeViewModel.getAllActivities
    Scaffold(
        topBar = {
            TopAppBar({
                dispatcher.onBackPressed()
            }, modifier = modifier, "All Activities")
        },
    ) { innerPadding ->
        Box(modifier = modifier.padding(innerPadding)) {
            ActivitiesList(modifier = modifier, navigateTo = navigateTo, activities = activities)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllActivitiesScreenPreview() {
    MyMoneyManagementAppTheme {

    }
}