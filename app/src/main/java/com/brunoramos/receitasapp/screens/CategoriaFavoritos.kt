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
fun CategoriaFavoritos(
    favoritos: List<Receita>,
    onBack: () -> Unit,
    onReceitaClick: (Receita) -> Unit
) {
    var pesquisa by remember { mutableStateOf("") }

    val favoritosFiltrados = favoritos.filter {
        it.nome.contains(pesquisa, ignoreCase = true)
    }

    Column {
        Button(onClick = onBack, modifier = Modifier.padding(8.dp)) {
            Text("Voltar")
        }

        TextField(
            value = pesquisa,
            onValueChange = { pesquisa = it },
            label = { Text("Pesquisar favorito") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            singleLine = true
        )

        if (favoritosFiltrados.isEmpty()) {
            Text("Nenhuma receita favorita encontrada.", modifier = Modifier.padding(16.dp))
        } else {
            LazyColumn {
                items(favoritosFiltrados) { receita ->
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
}

