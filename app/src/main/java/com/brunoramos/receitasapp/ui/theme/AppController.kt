package com.brunoramos.receitasapp.ui.theme

import androidx.compose.runtime.*
import com.brunoramos.receitasapp.screens.*
import com.brunoramos.receitasapp.models.Receita

@Composable
fun AppController() {
    var showPeixe by remember { mutableStateOf(false) }
    var showCarne by remember { mutableStateOf(false) }
    var showSobremesas by remember { mutableStateOf(false) }
    var showFavoritos by remember { mutableStateOf(false) }
    var receitaSelecionada by remember { mutableStateOf<Receita?>(null) }

    val favoritos = remember { mutableStateListOf<Receita>() }

    when {
        receitaSelecionada != null -> ReceitaDetalhes(
            receita = receitaSelecionada!!,
            onBack = { receitaSelecionada = null },
            onFavoritoClick = { receita ->
                if (favoritos.contains(receita)) {
                    favoritos.remove(receita)
                } else {
                    favoritos.add(receita)
                }
            },
            isFavorito = favoritos.contains(receitaSelecionada)
        )

        showFavoritos -> CategoriaFavoritos(
            favoritos = favoritos,
            onBack = { showFavoritos = false },
            onReceitaClick = { receitaSelecionada = it }
        )

        showPeixe -> CategoriaPeixe(
            onBack = { showPeixe = false },
            onReceitaClick = { receitaSelecionada = it }
        )

        showCarne -> CategoriaCarne(
            onBack = { showCarne = false },
            onReceitaClick = { receitaSelecionada = it }
        )

        showSobremesas -> CategoriaSobremesas(
            onBack = { showSobremesas = false },
            onReceitaClick = { receitaSelecionada = it }
        )

        else -> MainMenu(
            onPeixeClick = { showPeixe = true },
            onCarneClick = { showCarne = true },
            onSobremesasClick = { showSobremesas = true },
            onFavoritosClick = { showFavoritos = true }
        )
    }
}

