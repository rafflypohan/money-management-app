package com.example.mymoneymanagementapp.ui.components.latestActivities

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mymoneymanagementapp.core.data.Dummy
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.ui.routes.Destinations
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme

@Composable
fun Activities(onTextButtonClick: (String) -> Unit, navigateTo: (String) -> Unit, activities: List<ActivityModel>?, modifier: Modifier) {
    Column(modifier.fillMaxWidth()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Latest Activities", style = MaterialTheme.typography.titleMedium)
            TextButton(onClick = {
                onTextButtonClick(Destinations.ALL_ACTIVITIES_ROUTE)
            }, contentPadding = PaddingValues(0.dp), modifier = modifier.height(32.dp)) {
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Spacer(modifier = modifier.height(2.dp))
        ActivitiesList(modifier = modifier.padding(0.dp), navigateTo, activities = activities)
    }
}

@Preview(showBackground = true)
@Composable
fun ActivitiesPreview() {
    MyMoneyManagementAppTheme {
        Activities({  }, {}, Dummy.activities, Modifier)
    }
}

