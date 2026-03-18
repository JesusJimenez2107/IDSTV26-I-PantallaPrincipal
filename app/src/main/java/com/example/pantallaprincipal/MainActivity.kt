package com.example.pantallaprincipal.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pantallaprincipal.navigation.AppNavigation
import com.example.pantallaprincipal.screens.ListItemsExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //AppNavigation()
            ListItemsExample()
        }
    }
}