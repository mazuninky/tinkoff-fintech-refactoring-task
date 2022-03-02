package ru.tinkoff.fintech.refactoring

data class Pizza(
    val name: String,
) {
    override fun toString() = name
}

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

class Ingredient(private val ingredient: Pair<String, Int>) {
    val name get() = ingredient.first
    val count get() = ingredient.second
    val price
        get() = when (name) {
            "яйца" -> 3.48
            "бекон" -> 6.48
            "тесто" -> 1.00
            "томат" -> 1.53
            "оливки" -> 1.53
            "сыр" -> 0.98
            "пармезан" -> 3.98
            "грибы" -> 3.34
            "спаржа" -> 3.34
            "мясное ассорти" -> 9.38
            "вяленая говядина" -> 12.24
            else -> error("Неизвестный ингредиент")
        }
}