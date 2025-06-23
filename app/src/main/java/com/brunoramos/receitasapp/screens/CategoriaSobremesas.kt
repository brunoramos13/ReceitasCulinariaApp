package com.brunoramos.receitasapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoriaSobremesas(onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Sobremesas", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("🍮 Pudim de ovos")
        Text("🍫 Mousse de chocolate")
        Text("🍓 Tarte de morango")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onBack) {
            Text("Voltar")
        }
    }
}
