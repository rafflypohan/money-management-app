package com.example.mymoneymanagementapp.ui.features.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymoneymanagementapp.R
import com.example.mymoneymanagementapp.ui.components.BalanceCard
import com.example.mymoneymanagementapp.ui.components.IncomeExpenseSection
import com.example.mymoneymanagementapp.ui.components.latestActivities.Activities
import com.example.mymoneymanagementapp.ui.routes.Destinations
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navigateTo: (String) -> Unit,
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navigateTo(Destinations.ADD_ACTIVITY_ROUTE)
            }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
            }
        }
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            val activities by homeViewModel.getAllActivities
            val totalAmount by remember { homeViewModel.getTotalAmount }
            val totalIncome by remember { homeViewModel.getTotalIncome }
            val totalExpense by remember { homeViewModel.getTotalExpense }

            Spacer(modifier = modifier.height(16.dp))
            HomeScreenHeader(onIconButtonClick = {
                navigateTo(Destinations.HOME_ROUTE)
            }, modifier)
            Spacer(modifier = modifier.height(22.dp))
            BalanceCard(modifier = modifier, totalAmount)
            Spacer(modifier = modifier.height(20.dp))

            IncomeExpenseSection(
                modifier = modifier,
                income = totalIncome,
                expense = totalExpense
            )
            Spacer(modifier = modifier.height(16.dp))
            Activities(onTextButtonClick = {
                navigateTo(Destinations.ALL_ACTIVITIES_ROUTE)
            }, navigateTo = navigateTo, activities = activities, modifier = modifier)
        }
    }

}

@Composable
fun HomeScreenHeader(onIconButtonClick: (String) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(
                text = "Hello, Budi",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Light
            )
            Text(
                text = "Welcome Back!",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
        IconButton(onClick = {

        }, modifier = modifier.size(24.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.notifications_outlined),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyMoneyManagementAppTheme() {
        HomeScreen({}, modifier = Modifier)
    }
}