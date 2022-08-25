package com.example.mymoneymanagementapp.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogComponentsContent(
    title: String,
    contentText: String,
    dialogState: MutableState<Boolean>,
    successButtonText: String,
    onSuccessButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(), shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            BodyContent(title, contentText)
            BottomButtonsSection(successButtonText, onSuccessButtonClick, dialogState)
        }
    }
}

@Composable
fun BodyContent(title: String, contentText: String) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
        Text(text = title, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = contentText, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.fillMaxWidth(), softWrap = true)
    }
}

@Composable
fun BottomButtonsSection(
    successButtonText: String,
    onSuccessButtonClick: () -> Unit,
    dialogState: MutableState<Boolean>
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(onClick = { dialogState.value = false }) {
            Text(text = "Cancel")
        }
        Button(onClick = onSuccessButtonClick, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error, contentColor = Color.White)) {
            Text(text = successButtonText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDialogComponentsContent(){
    MyMoneyManagementAppTheme {
        DialogComponentsContent("Tes", "Testestes", mutableStateOf(false), "Delete", {})

    }
}