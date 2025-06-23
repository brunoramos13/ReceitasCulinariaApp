package com.brunoramos.receitasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.brunoramos.receitasapp.ui.theme.ReceitasAppTheme
import com.brunoramos.receitasapp.ui.theme.AppController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReceitasAppTheme {
                AppController()
            }
        }
    }
}