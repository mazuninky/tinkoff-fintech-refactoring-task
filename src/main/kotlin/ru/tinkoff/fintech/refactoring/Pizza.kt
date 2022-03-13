package ru.tinkoff.fintech.refactoring

data class Pizza(
    val name: String,
)

fun getIngredient(pizza: Pizza): List<Pair<String, Int>> {
    return PizzaIngredients().listOfIngredients.getOrDefault(pizza.name, emptyList())
}

fun getPizzaOrderInfo(ingredients: List<Pair<String, Int>>, action : String) : PizzaOrderInfo {
    var pizzaPrice = 0.0
    var ingredientCounter = 0
    ingredients.forEach { ingredient ->
        val (price, count) = PizzaIngredients().getPriceAndCount(ingredient)
        ingredientCounter += count
        pizzaPrice += price
        if (action == "make")
            println("[Пицца мейкер] - ${ingredient.first}: в количестве ${ingredient.second} за $price$")
    }
    return PizzaOrderInfo(
        pizzaPrice = pizzaPrice,
        ingredientCounter = ingredientCounter
    )
}