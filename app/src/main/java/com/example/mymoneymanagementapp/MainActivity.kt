package com.example.mymoneymanagementapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.mymoneymanagementapp.core.data.Dummy
import com.example.mymoneymanagementapp.ui.components.Navbar
import com.example.mymoneymanagementapp.ui.routes.NavigationGraph
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoneyManagementAppTheme {
                MoneyManagerApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoneyManagerApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            Navbar(navController) {
                navController.navigate(it.route)
            }
        }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationGraph(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoneyManagerAppPreview() {
    MyMoneyManagementAppTheme {
        MoneyManagerApp()
    }
}
