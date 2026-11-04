package com.example.jiji.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavTab(val title: String, val icon: ImageVector) {
    HOME("Home", Icons.Default.Home),
    SAVED("Saved", Icons.Default.Bookmark),
    SELL("Sell", Icons.Default.Add),
    MESSAGES("Messages", Icons.Default.ChatBubble),
    PROFILE("Profile", Icons.Default.Person)
}
