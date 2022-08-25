package com.example.mymoneymanagementapp.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.mymoneymanagementapp.utils.formatDateToString
import java.util.*

@Composable
fun AddEditForm(
    modifier: Modifier = Modifier,
    activityName: MutableState<String>,
    amount: MutableState<String>,
    selectedDate: MutableState<Date>,
    isExpense: MutableState<Boolean>,
    onSubmitButtonClick: () -> Unit
) {
    // TODO: Change title and text field text style
    // TODO: Change Expanded Dropdown background color
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // date picker
        val showPicker = remember {
            mutableStateOf(false)
        }

        // dropdown
        val dropdownListOptions = listOf("Expense", "Income")
        var expanded by remember {
            mutableStateOf(false)
        }
        var selectedOptionText by remember {
            mutableStateOf(
                if (isExpense.value) dropdownListOptions[0] else dropdownListOptions[1]
            )
        }
        isExpense.value = selectedOptionText == "Expense"
        Log.d("Form ", activityName.value)
        Log.d("Form ", selectedOptionText)
        Log.d("Form ", isExpense.value.toString())

        if (showPicker.value) {
            DatePicker(onDateSelected = {
                selectedDate.value = it
            }, onDismissRequest = {
                showPicker.value = false
            })
        }

        Dropdown(
            isExpanded = expanded,
            listOptions = dropdownListOptions,
            onSelectedItem = selectedOptionText,
            onExpandedChange = {
                expanded = !expanded
            },
            onDismissRequest = { expanded = false },
            onMenuItemClick = {
                selectedOptionText = it
                expanded = false
            }
        )

        Spacer(modifier = modifier.height(16.dp))
        ActivityNameSection(modifier, activityName)

        Spacer(modifier = modifier.height(16.dp))
        AmountSection(modifier, amount)

        Spacer(modifier = modifier.height(16.dp))
        DateSection(modifier, showPicker, selectedDate)

        Spacer(modifier = modifier.height(28.dp))
        SubmitButton(modifier, onSubmitButtonClick)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityNameSection(modifier: Modifier = Modifier, activityName: MutableState<String>) {
    Text(text = "Activity Name", style = MaterialTheme.typography.titleSmall)
    Spacer(modifier = modifier.height(2.dp))
    TextField(
        value = activityName.value,
        onValueChange = {
            activityName.value = it
        },
        textStyle = MaterialTheme.typography.bodyMedium,
        placeholder = {
            Text(text = "Enter your activity")
        },
        shape = RoundedCornerShape(
            14.dp
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmountSection(modifier: Modifier = Modifier, amount: MutableState<String>) {
    Text(text = "Amount", style = MaterialTheme.typography.titleSmall)
    Spacer(modifier = modifier.height(2.dp))
    Row {
        TextField(
            modifier = modifier
                .fillMaxWidth(0.2f)
                .padding(PaddingValues(0.dp)),
            value = "Rp",
            onValueChange = {},
            enabled = false,
            readOnly = true,
            textStyle = MaterialTheme.typography.bodyMedium,
            shape = RoundedCornerShape(
                topStart = 14.dp,
                topEnd = 0.dp,
                bottomStart = 14.dp,
                bottomEnd = 0.dp
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
        )
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = amount.value.replaceFirst(Regex("^0+(?!$)"), ""),
            onValueChange = { newValue ->
                amount.value = newValue.replaceFirst(Regex("^0+(?!$)"), "")
                if (newValue.isEmpty() || amount.value.isEmpty()) {
                    amount.value = "0"
                }
            },
            textStyle = MaterialTheme.typography.bodyMedium,
            placeholder = {
                Text(text = "Enter your amount")
            },
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 14.dp,
                bottomStart = 0.dp,
                bottomEnd = 14.dp
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateSection(
    modifier: Modifier = Modifier,
    showPicker: MutableState<Boolean>,
    selectedDate: MutableState<Date>
) {
    Text(text = "Date", style = MaterialTheme.typography.titleSmall)
    Spacer(modifier = modifier.height(2.dp))
    // TODO Handle onValueChange and onDateSelected
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                showPicker.value = true
            },
        value = selectedDate.value.formatDateToString(),
        onValueChange = { selectedDate.value.formatDateToString() },
        textStyle = MaterialTheme.typography.bodyMedium,
        readOnly = true,
        enabled = false,
        placeholder = {
            Text(text = selectedDate.value.formatDateToString())
        },
        trailingIcon = {
            // TODO: change color tint
            Icon(
                imageVector = Icons.Rounded.DateRange,
                contentDescription = null,
                tint = Color.Black
            )
        },
        shape = RoundedCornerShape(
            14.dp
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
    )
}

@Composable
fun SubmitButton(modifier: Modifier = Modifier, onSubmitButtonClick: () -> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        onClick = onSubmitButtonClick,
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(text = "Submit", style = MaterialTheme.typography.titleMedium)
    }
}