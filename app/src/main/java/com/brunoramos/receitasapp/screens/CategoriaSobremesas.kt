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
import androidx.compose.ui.Alignment

@Composable
fun CategoriaSobremesas(
    onBack: () -> Unit,
    onReceitaClick: (Receita) -> Unit
) {

    var pesquisa by remember { mutableStateOf("") }

    val receitasSobremesas = listOf(
        Receita(
            nome = "Pastel de Nata",
            descricao = "Deliciosos pastéis com creme e massa folhada.",
            imagemUrl = "https://www.unileverfoodsolutions.pt/dam/global-ufs/mcos/portugal/calcmenu/recipes/PT-recipes/2021/menu-do-dia/pastel-nata-cafe-main-header.jpg",
            passos = listOf(
                "Pré-aquecer o forno.",
                "Preparar o creme com ovos, açúcar e natas.",
                "Colocar o creme na massa folhada.",
                "Levar ao forno até dourar."
            )
        ),
        Receita(
            nome = "Arroz Doce",
            descricao = "Arroz cremoso com canela e açúcar.",
            imagemUrl = "https://static.itdg.com.br/images/640-400/202bb6fc223a1c52fec8cd91921d35ff/202541-193166-original.jpg",
            passos = listOf(
                "Cozer o arroz em leite com açúcar.",
                "Adicionar canela e raspa de limão.",
                "Cozinhar até engrossar.",
                "Servir frio ou morno."
            )
        )
    )

    val receitasFiltradas = receitasSobremesas.filter {
        it.nome.contains(pesquisa, ignoreCase = true)
    }

    Column {
        Button(
            onClick = onBack,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Voltar")
        }

        TextField(
            value = pesquisa,
            onValueChange = { pesquisa = it },
            label = { Text("Pesquisar sobremesa") },
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
