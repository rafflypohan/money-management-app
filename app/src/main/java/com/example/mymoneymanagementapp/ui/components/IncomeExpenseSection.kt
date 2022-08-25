package com.example.mymoneymanagementapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymoneymanagementapp.R
import com.example.mymoneymanagementapp.ui.theme.Green30
import com.example.mymoneymanagementapp.ui.theme.Green90
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme
import com.example.mymoneymanagementapp.utils.toCurrencyFormat

@Composable
fun IncomeExpenseSection(modifier: Modifier, income: Long, expense: Long){
    Row(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        Row(modifier = modifier.fillMaxWidth(0.5f), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = modifier
                .wrapContentSize(align = Alignment.Center)
                .clip(RoundedCornerShape(6.dp))
                .background(Green90)
            ) {
                Icon(painterResource(id = R.drawable.arrow_downward), contentDescription = "", tint = Green30, modifier = modifier
                    .size(45.dp)
                    .padding(10.dp))
            }
            Spacer(modifier = modifier.width(8.dp))
            Column(modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                Text(text = "Income", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Light, fontSize = 10.sp)
                Spacer(modifier = modifier.height(2.dp))
                Text(text = income.toCurrencyFormat(), style = MaterialTheme.typography.titleSmall)
            }
        }
        Row(modifier = modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
            Box(modifier = modifier
                .wrapContentSize(align = Alignment.Center)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.errorContainer)
            ) {
                Icon(painterResource(id = R.drawable.arrow_upward), contentDescription = "", tint = MaterialTheme.colorScheme.error, modifier = modifier
                    .size(45.dp)
                    .padding(10.dp))
            }
            Spacer(modifier = modifier.width(8.dp))
            Column() {
                Text(text = "Expense", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Light, fontSize = 10.sp)
                Spacer(modifier = modifier.height(2.dp))
                Text(text = expense.toCurrencyFormat(), style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IncomeExpenseSectionPreview(){
    MyMoneyManagementAppTheme() {
        IncomeExpenseSection(modifier = Modifier, 5000L, 2000L)
    }
}