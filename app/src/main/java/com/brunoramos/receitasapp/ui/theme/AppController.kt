package com.brunoramos.receitasapp.ui.theme

import androidx.compose.runtime.*
import com.brunoramos.receitasapp.screens.*

@Composable
fun AppController() {
    var showPeixe by remember { mutableStateOf(false) }
    var showCarne by remember { mutableStateOf(false) }
    var showSobremesas by remember { mutableStateOf(false) }

    when {
        showPeixe -> CategoriaPeixe(onBack = { showPeixe = false })
        showCarne -> CategoriaCarne(onBack = { showCarne = false })
        showSobremesas -> CategoriaSobremesas(onBack = { showSobremesas = false })
        else -> MainMenu(
            onPeixeClick = { showPeixe = true },
            onCarneClick = { showCarne = true },
            onSobremesasClick = { showSobremesas = true }
        )
    }
}
