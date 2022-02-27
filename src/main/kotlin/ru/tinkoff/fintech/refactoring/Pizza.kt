package ru.tinkoff.fintech.refactoring

class Pizza(val name: String, private val ingredientsPrice: IngredientsPrice) {

    private var pizzaMenuWithIngredients = mutableMapOf(
        "карбонара" to listOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2),
        "маринара" to listOf("томат" to 2, "оливки" to 3, "тесто" to 1),
        "сардиния" to listOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3),
        "вальтеллина" to listOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2),
        "крестьянская" to listOf("грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1))

    fun getPizzaInfoPriceTime(): List<Any> {
        var pizzaPrice = 0.0
        var ingredientCounterAndTime = 0
        val textIngredientWithPrice= mutableListOf<String>()
        pizzaMenuWithIngredients[name]?.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second
            val price = ingredientsPrice.getPrice(ingredientName)
            textIngredientWithPrice.add("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounterAndTime += ingredientCount
        }
        return listOf<Any>(textIngredientWithPrice.joinToString("\n"), pizzaPrice, ingredientCounterAndTime)
    }

    // fun addInPizzaMenu
}

class PizzaOrder(private val numberOrder: Int, private val pizza: Pizza) {
    fun getNumberOrder() = numberOrder
    fun getNamePizza() = pizza.name
    fun getTextIngredientWithPrice() = pizza.getPizzaInfoPriceTime()[0]
    fun getPricePizza() = pizza.getPizzaInfoPriceTime()[1]
    fun getTimeInMinutesPizza() = pizza.getPizzaInfoPriceTime()[2]
}

