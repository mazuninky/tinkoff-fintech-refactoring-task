package ru.tinkoff.fintech.refactoring

data class Pizza(
    val name: String
)

fun getIngredient(pizza: Pizza): List<Pair<String, Int>> {
    return when (pizza.name) {
        "карбонара" -> listOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2)
        "маринара" -> listOf("томат" to 2, "оливки" to 3, "тесто" to 1)
        "сардиния" -> listOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3)
        "вальтеллина" -> listOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2)
        "крестьянская" -> listOf("грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1)
        else -> emptyList()
    }
}

