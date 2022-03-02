package ru.tinkoff.fintech.refactoring


data class Pizza(val name: String, val pizzaValueIngredients: MutableMap<String, List<Pair<String, Int>>>) {

    private var ingredientsPrice = mutableMapOf(
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
        "вяленая говядина" to 12.24
    )

    fun getPizzaTextPriceTime(): List<Any> {
        var pizzaPrice = 0.0
        var ingredientCounterAndTime = 0
        val textIngredientWithPrice = mutableListOf<String>()
        pizzaValueIngredients[name]?.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second
            val price = ingredientsPrice[ingredientName] ?: error("Неизвестный ингредиент")
            textIngredientWithPrice.add("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounterAndTime += ingredientCount
        }
        return listOf<Any>(textIngredientWithPrice.joinToString("\n"), pizzaPrice, ingredientCounterAndTime)
    }

}



