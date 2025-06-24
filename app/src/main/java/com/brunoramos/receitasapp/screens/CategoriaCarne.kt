package com.brunoramos.receitasapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.brunoramos.receitasapp.models.Receita
import androidx.compose.foundation.clickable

@Composable
fun CategoriaCarne(
    onBack: () -> Unit,
    onReceitaClick: (Receita) -> Unit
) {
    var pesquisa by remember { mutableStateOf("") }

    val receitasCarne = listOf(
        Receita(
            nome = "Carne de Porco à Alentejana",
            descricao = "Carne de porco com amêijoas e batatas.",
            imagemUrl = "https://www.pingodoce.pt/wp-content/uploads/2015/10/carne-de-porco-a-alentejana-1.jpg",
            passos = listOf(
                "Temperar a carne com alho e pimenta.",
                "Refogar a carne em azeite.",
                "Adicionar amêijoas e cozer até abrir.",
                "Servir com batatas fritas."
            )
        ),
        Receita(
            nome = "Bife à Portuguesa",
            descricao = "Bife com molho de vinho e batata frita.",
            imagemUrl = "https://www.pingodoce.pt/wp-content/uploads/2016/09/bife-de-vitela-a-portuguesa.jpeg",
            passos = listOf(
                "Temperar o bife com sal e pimenta.",
                "Fritar o bife em azeite quente.",
                "Preparar molho com vinho branco e alho.",
                "Adicionar presunto no topo do bife.",
                "Servir o bife com o molho e batatas."
            )
        )
    )

    val receitasFiltradas = receitasCarne.filter {
        it.nome.contains(pesquisa, ignoreCase = true)
    }

    Column {
        Button(onClick = onBack, modifier = Modifier.padding(8.dp)) {
            Text("Voltar")
        }

        TextField(
            value = pesquisa,
            onValueChange = { pesquisa = it },
            label = { Text("Pesquisar receita") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            singleLine = true
        )

        LazyColumn {
            items(receitasFiltradas) { receita ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { onReceitaClick(receita) }
                    ) {
                        Text(text = receita.nome, style = MaterialTheme.typography.titleLarge)
                        Text(text = receita.descricao, style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        AsyncImage(
                            model = receita.imagemUrl,
                            contentDescription = receita.nome,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}

