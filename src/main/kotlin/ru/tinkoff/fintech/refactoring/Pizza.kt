package ru.tinkoff.fintech.refactoring


enum class Pizza(val pizzaName: String, val pizzaValueIngredients: Map<String, Int>) {
    CARBONARA(
        "карбонара", mapOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2)
    ),
    MARINARA(
        "маринара", mapOf("томат" to 2, "оливки" to 3, "тесто" to 1)
    ),
    SARDINIA(
        "сардиния", mapOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3)
    ),
    VALTELLINA(
        "вальтеллина", mapOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2)
    ),
    PEASANT(
        "крестьянская", mapOf(
            "грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1
        )
    );


    companion object {
        fun getPizzaByName(name: String): Pizza = values().find { it.pizzaName == name.lowercase() }
            ?: error("Неизвестный вид пиццы!")

    }


}
/*
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
    return listOf<Any>(
        textIngredientWithPrice.joinToString("\n"),
        pizzaPrice,
        ingredientCounterAndTime
    )
}

}
*/


