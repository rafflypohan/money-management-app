package com.example.mymoneymanagementapp.ui.components

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        decayAnimationSpec = decayAnimationSpec, rememberTopAppBarState()
    )
    SmallTopAppBar(
        title = { Text(text = "Home Screen") },
        actions = {
        },
        scrollBehavior = scrollBehavior
    )
}