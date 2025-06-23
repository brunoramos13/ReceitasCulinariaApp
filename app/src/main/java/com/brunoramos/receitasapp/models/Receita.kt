package com.brunoramos.receitasapp.models

data class Receita(
    val nome: String,
    val descricao: String,
    val imagemUrl: String,
    val passos: List<String> = emptyList()
)
