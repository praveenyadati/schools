package com.dheep.schools.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun DetailsScreen(name: String) {
    Text(text = name, color = Color.Black)
}