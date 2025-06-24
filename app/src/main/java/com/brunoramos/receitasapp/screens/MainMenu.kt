package com.brunoramos.receitasapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import com.brunoramos.receitasapp.R



@Composable
fun MainMenu(
    onPeixeClick: () -> Unit,
    onCarneClick: () -> Unit,
    onSobremesasClick: () -> Unit,
    onFavoritosClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Imagem de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        //filtro transparente para se ver melhor as letras
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Black.copy(alpha = 0.3f), Color.Transparent)
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Receitas de Culinária",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )

            Button(onClick = onPeixeClick) {
                Text("Pratos de Peixe")
            }
            Button(onClick = onCarneClick) {
                Text("Pratos de Carne")
            }
            Button(onClick = onSobremesasClick) {
                Text("Sobremesas")
            }
            Button(onClick = onFavoritosClick) {
                Text("Favoritos ⭐")
            }
        }
    }
}
