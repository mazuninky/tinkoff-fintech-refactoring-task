package ru.tinkoff.fintech.refactoring

class PizzaIngredients {
    var listOfIngredients = mapOf(
        "карбонара" to listOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2),
        "маринара" to listOf("томат" to 2, "оливки" to 3, "тесто" to 1),
        "сардиния" to listOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3),
        "вальтеллина" to listOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2),
        "крестьянская" to listOf("грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1),
    )
    var listOfIngredientsPrice = mapOf(
        "яйца" to 3.48,
        "бекон" to 6.48,
        "тесто" to 1.00,
        "томат" to 1.53,
        "оливки" to 1.53,
        "сыр" to 0.98,
        "пармезан" to 3.98,
        "грибы" to 3.34,
        "спаржа" to 3.34,
        "мясное ассорти" to 9.38,
        "вяленая говядина" to 12.24,
    )
    fun getPriceAndCount(ingredient : Pair<String, Int>) : Pair <Double, Int> {
        val price = listOfIngredientsPrice[ingredient.first];
        if ( price != null ) return Pair(price * ingredient.second, ingredient.second)
        else error("Неизвестный ингредиент")
    }
}