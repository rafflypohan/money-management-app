package com.example.mymoneymanagementapp.ui.features.detail

import android.widget.Toast
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymoneymanagementapp.core.domain.models.ActivityModel
import com.example.mymoneymanagementapp.ui.components.DialogComponentsContent
import com.example.mymoneymanagementapp.ui.routes.Destinations
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailActivityScreen(
    navigateTo: (String) -> Unit,
    activityId: Int?,
    detailActivityViewModel: DetailActivityViewModel = hiltViewModel()
) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher
    val detail by detailActivityViewModel.getActivityById(activityId!!)
        .collectAsState(initial = ActivityModel(0, "", 0, "", true))
    val deleteDialogState = remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (deleteDialogState.value) {
        Dialog(
            onDismissRequest = { /*TODO*/ },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            DialogComponentsContent(
                title = "Delete",
                contentText = "Are you sure want to delete ${detail.activityName} from your activity?",
                dialogState = deleteDialogState,
                successButtonText = "Delete",
                onSuccessButtonClick = {
                    detailActivityViewModel.deleteActivity(detail)
                        .invokeOnCompletion {
                            deleteDialogState.value = false
                            dispatcher.onBackPressed()
                        }
                }
            )
        }
    } else {
        Toast.makeText(context, "Dialog closed", Toast.LENGTH_SHORT).show()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Details") },
                navigationIcon = {
                    IconButton(onClick = { dispatcher.onBackPressed() }) {
                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    Row {
                        IconButton(onClick = {
                            navigateTo("${Destinations.EDIT_ACTIVITY_ROUTE}/${detail.id}")
                        }) {
                            Icon(imageVector = Icons.Outlined.Edit, contentDescription = null)
                        }
                        IconButton(onClick = {
                            deleteDialogState.value = true
                        }) {
                            Icon(imageVector = Icons.Outlined.Delete, contentDescription = null)
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            DetailActivityContent(
                name = detail.activityName,
                amount = detail.amount,
                date = detail.date,
                isExpense = detail.isExpense
            )
        }
    }

}

@Composable
fun DetailActivityContent(
    modifier: Modifier = Modifier,
    name: String,
    amount: Long,
    date: String,
    isExpense: Boolean
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val title = listOf("Amount", "Date", "Status")
        val value = listOf("Rp $amount", date, if (isExpense) "Expense" else "Income")
        val titleValue = title.zip(value)
        Text(
            text = name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(20.dp))
        LazyColumn() {
            items(titleValue) { r ->
                TableContent(title = r.first, value = r.second)
            }
        }
    }
}

@Composable
fun TableContent(
    title: String,
    value: String
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.fillMaxWidth(0.38f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth()
        )
    }
    Spacer(modifier = Modifier.height(12.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailActivityScreen() {
    MyMoneyManagementAppTheme {
        DetailActivityContent(name = "Bakso", amount = 500, date = "12 June 2022", isExpense = true)
    }
}
