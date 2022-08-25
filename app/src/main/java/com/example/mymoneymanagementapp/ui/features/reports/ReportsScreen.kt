package com.example.mymoneymanagementapp.ui.features.reports

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymoneymanagementapp.core.data.Dummy
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportsScreen(
    modifier: Modifier = Modifier,
    navigateTo: (String) -> Unit,
    viewModel: ReportsViewModel = hiltViewModel()
) {
    Scaffold() { innerPadding ->
        val activities by viewModel.getAllActivities
        val totalExpenses by remember {
            viewModel.getTotalExpense
        }
        Box(modifier = modifier.padding(innerPadding)) {
            ReportContent(modifier,activities, totalExpenses)
        }
    }
}

@Composable
fun ReportContent(modifier: Modifier = Modifier, activities: List<ActivityModel>, totalExpenses: Long) {

}

@Preview(showBackground = true)
@Composable
fun PreviewReportsScreen() {
    MyMoneyManagementAppTheme {
        ReportContent(activities = Dummy.activities, totalExpenses = 0L)
    }
}
