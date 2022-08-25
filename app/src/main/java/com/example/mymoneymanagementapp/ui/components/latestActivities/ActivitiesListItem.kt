package com.example.mymoneymanagementapp.ui.components.latestActivities

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mymoneymanagementapp.R
import com.example.mymoneymanagementapp.ui.theme.Green30
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme
import com.example.mymoneymanagementapp.utils.toCurrencyFormat

@Composable
fun ActivitiesListItem(
    onItemClick: () -> Unit,
    activityName: String,
    amount: Long,
    date: String,
    isExpense: Boolean,
    modifier: Modifier
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .clickable(onClick = onItemClick )
        .padding(16.dp, 12.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Icon(painterResource(id = if (isExpense) R.drawable.arrow_upward  else R.drawable.arrow_downward), contentDescription = "", tint = if (isExpense) MaterialTheme.colorScheme.error else Green30, modifier = modifier
            .fillMaxWidth(0.08f)
            .size(20.dp)
        )
        Spacer(modifier = modifier.width(12.dp))
        Column(modifier = modifier.fillMaxWidth(0.65f)) {
            Text(text = activityName, style = MaterialTheme.typography.bodyMedium)
            Text(text = date, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Light)
        }
        Spacer(modifier = modifier.width(8.dp))
        val correctAmount = amount.toCurrencyFormat()
        Text(text = if (isExpense) "-$correctAmount" else "+$correctAmount", style = MaterialTheme.typography.bodySmall, color = if (isExpense) MaterialTheme.colorScheme.error else Green30, textAlign = TextAlign.End, modifier = modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityListItemPreview(){
    MyMoneyManagementAppTheme {
        ActivitiesListItem({  }, "Makan Bakso", 20000L, "Yesterday", true, Modifier)
    }
}

