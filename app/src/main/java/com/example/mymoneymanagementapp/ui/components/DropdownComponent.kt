package com.example.mymoneymanagementapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dropdown(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    listOptions: List<String>,
    onSelectedItem: String,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequest: () -> Unit,
    onMenuItemClick: (String) -> Unit,
) {

// We want to react on tap/press on TextField to show menu
    ExposedDropdownMenuBox(
        modifier = modifier.fillMaxWidth(),
        expanded = isExpanded,
        onExpandedChange = onExpandedChange,
    ) {
        TextField(
            modifier = modifier.fillMaxWidth(),
            readOnly = true,
            value = onSelectedItem,
            onValueChange = {},
            textStyle = MaterialTheme.typography.bodyMedium,
            shape = RoundedCornerShape(
                14.dp
            ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = onDismissRequest
        ) {
            listOptions.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = { onMenuItemClick(selectionOption) }
//                        onSelectedItem = selectionOption
//                        isExpanded = false
                )
            }


        }
    }
}
