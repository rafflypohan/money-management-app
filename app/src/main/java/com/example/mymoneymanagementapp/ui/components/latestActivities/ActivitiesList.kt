package com.example.mymoneymanagementapp.ui.components.latestActivities

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mymoneymanagementapp.core.data.Dummy
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.ui.components.EmptyListScreen
import com.example.mymoneymanagementapp.ui.routes.Destinations
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme
import com.example.mymoneymanagementapp.utils.ignoreHorizontalParentPadding

@Composable
fun ActivitiesList(
    modifier: Modifier,
    navigateTo: (String) -> Unit,
    activities: List<ActivityModel>?
){
    if (activities.isNullOrEmpty()) {
        EmptyListScreen()
    } else {
        LazyColumn(modifier = modifier.ignoreHorizontalParentPadding(16.dp)) {
            items(items = activities.take(5), key = { act -> act.id }) { activity ->
                ActivitiesListItem(
                    onItemClick = { navigateTo("${Destinations.DETAIL_ACTIVITY_ROUTE}/${activity.id}") },
                    activityName = activity.activityName,
                    amount = activity.amount,
                    date = activity.date,
                    isExpense = activity.isExpense,
                    modifier = modifier
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActivitiesListPreview(){
    MyMoneyManagementAppTheme {
        ActivitiesList(
            modifier = Modifier,
            navigateTo = {},
            activities = Dummy.activities
        )
    }
}