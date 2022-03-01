package ru.tinkoff.fintech.refactoring

data class Pizza(
    val name: String,
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

fun getPizzaOrderInfo(ingredients: List<Pair<String, Int>>, action : String) : PizzaOrderInfo {
    var pizzaPrice = 0.0
    var ingredientCounter = 0
    ingredients.forEach { ingredient ->
        val ingredientName = ingredient.first
        val ingredientCount = ingredient.second

        val price = when (ingredientName) {
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
        ingredientCounter += ingredientCount
        pizzaPrice += price * ingredientCount
        if (action == "make")
            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
    }
    return PizzaOrderInfo(
        pizzaPrice = pizzaPrice,
        ingredientCounter = ingredientCounter
    )
}