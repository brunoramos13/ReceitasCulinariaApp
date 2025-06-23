package com.brunoramos.receitasapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainMenu(
    onPeixeClick: () -> Unit,
    onCarneClick: () -> Unit,
    onSobremesasClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Receitas de Culinária", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = onPeixeClick) {
            Text("Pratos de Peixe")
        }
        Button(onClick = onCarneClick) {
            Text("Pratos de Carne")
        }
        Button(onClick = onSobremesasClick) {
            Text("Sobremesas")
        }
    }
}