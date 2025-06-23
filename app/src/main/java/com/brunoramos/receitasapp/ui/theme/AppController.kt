package com.brunoramos.receitasapp.ui.theme

import androidx.compose.runtime.*
import com.brunoramos.receitasapp.screens.*
import com.brunoramos.receitasapp.models.Receita

@Composable
fun AppController() {
    var showPeixe by remember { mutableStateOf(false) }
    var showCarne by remember { mutableStateOf(false) }
    var showSobremesas by remember { mutableStateOf(false) }

    var receitaSelecionada by remember { mutableStateOf<Receita?>(null) }

    when {
        receitaSelecionada != null -> ReceitaDetalhes(
            receita = receitaSelecionada!!,
            onBack = { receitaSelecionada = null }
        )
        showPeixe -> CategoriaPeixe(
            onBack = { showPeixe = false },
            onReceitaClick = { receita -> receitaSelecionada = receita }
        )
        showCarne -> CategoriaCarne(
            onBack = { showCarne = false },
            onReceitaClick = { receita -> receitaSelecionada = receita }
        )
        showSobremesas -> CategoriaSobremesas(
            onBack = { showSobremesas = false },
            onReceitaClick = { receita -> receitaSelecionada = receita }
        )
        else -> MainMenu(
            onPeixeClick = { showPeixe = true },
            onCarneClick = { showCarne = true },
            onSobremesasClick = { showSobremesas = true }
        )
    }
}

