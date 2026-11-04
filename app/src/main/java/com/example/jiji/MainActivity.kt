package com.example.jiji

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jiji.ui.components.JijiBottomBar
import com.example.jiji.ui.navigation.NavTab
import com.example.jiji.ui.screens.*
import com.example.jiji.ui.theme.JijiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JijiTheme {
                JijiApp()
            }
        }
    }
}

@Composable
fun JijiApp() {
    var currentTab by remember { mutableStateOf(NavTab.HOME) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            JijiBottomBar(
                currentTab = currentTab,
                onTabSelected = { tab ->
                    currentTab = tab
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentTab) {
                NavTab.HOME -> HomeScreen(
                    onCategoryClick = { categoryName ->
                        if (categoryName == "Post Ad") {
                            currentTab = NavTab.SELL
                        }
                    }
                )
                NavTab.SAVED -> SavedScreen(
                    onBackClick = { currentTab = NavTab.HOME }
                )
                NavTab.SELL -> PostAdScreen(
                    onBackClick = { currentTab = NavTab.HOME }
                )
                NavTab.MESSAGES -> MessagesScreen(
                    onBackClick = { currentTab = NavTab.HOME }
                )
                NavTab.PROFILE -> ProfileScreen(
                    onBackClick = { currentTab = NavTab.HOME }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JijiAppPreview() {
    JijiTheme {
        JijiApp()
    }
}
