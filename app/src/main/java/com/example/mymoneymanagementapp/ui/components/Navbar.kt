package com.example.mymoneymanagementapp.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mymoneymanagementapp.ui.routes.Destinations
import com.example.mymoneymanagementapp.ui.routes.TopLevelDestinations
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme

@Composable
fun Navbar(navController: NavController, onItemClick: (TopLevelDestinations) -> Unit) {
    var selectedItem by remember {
        mutableStateOf(-0)
    }
    val items = Destinations.topLevelDestinations

    NavigationBar(containerColor = Color.White) {
        items.forEachIndexed { index, item ->
            val selected = selectedItem == index
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = if (selected) item.selectedIcon else item.defaultIcon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                selected = selected,
                onClick = {
                    selectedItem = index
                    onItemClick(item)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavbarPreview() {
    MyMoneyManagementAppTheme {

    }
}