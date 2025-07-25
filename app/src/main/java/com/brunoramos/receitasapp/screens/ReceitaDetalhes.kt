package com.brunoramos.receitasapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import com.brunoramos.receitasapp.models.Receita
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

@Composable
fun ReceitaDetalhes(
    receita: Receita,
    onBack: () -> Unit,
    onFavoritoClick: (Receita) -> Unit,
    isFavorito: Boolean
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = onBack) {
                Text("Voltar")
            }

            IconButton(onClick = { onFavoritoClick(receita) }) {
                Icon(
                    imageVector = if (isFavorito) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favoritar",
                    tint = if (isFavorito) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = receita.nome, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))

        AsyncImage(
            model = receita.imagemUrl,
            contentDescription = receita.nome,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Modo de preparação:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        receita.passos.forEachIndexed { index, passo ->
            Text(text = "${index + 1}. $passo", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

