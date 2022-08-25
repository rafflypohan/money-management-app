package com.example.mymoneymanagementapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme
import com.example.mymoneymanagementapp.utils.toCurrencyFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BalanceCard(modifier: Modifier, totalAmount: Long?) {
    Card(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()
        ) {
        Column(modifier = modifier.padding(20.dp)) {
            Text(text = "Total Balance", style = MaterialTheme.typography.labelMedium)
            Spacer(modifier = modifier.height(2.dp))
            Text(text = totalAmount?.toCurrencyFormat() ?: 0L.toCurrencyFormat(), style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold, modifier = modifier.fillMaxWidth())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BalanceCardPreview(){
    MyMoneyManagementAppTheme {
        BalanceCard(modifier = Modifier, 2500000L)
    }
}