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
fun CategoriaPeixe(
    onBack: () -> Unit,
    onReceitaClick: (Receita) -> Unit
) {
    var pesquisa by remember { mutableStateOf("") }

    val receitasPeixe = listOf(
        Receita(
            nome = "Bacalhau à Brás",
            descricao = "Bacalhau desfiado com batata palha e ovo.",
            imagemUrl = "https://receitasecomida.com/wp-content/uploads/bacalhau-com-natas-500x464.jpg",
            passos = listOf(
                "Desfiar o bacalhau.",
                "Fritar batata palha.",
                "Misturar bacalhau com batata e ovo mexido.",
                "Servir quente."
            )
        ),
        Receita(
            nome = "Arroz de Marisco",
            descricao = "Delicioso arroz com camarão e mexilhão.",
            imagemUrl = "https://gastroportugal.com/wp-content/uploads/seafood-rice.jpg",
            passos = listOf(
                "Preparar o caldo de marisco.",
                "Refogar cebola e alho.",
                "Adicionar arroz e caldo.",
                "Adicionar marisco e cozinhar até o arroz estar macio."
            )
        )
    )

    val receitasFiltradas = receitasPeixe.filter {
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
                        .padding(8.dp)
                        .clickable { onReceitaClick(receita) },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
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


