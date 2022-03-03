package ru.tinkoff.fintech.refactoring

class Storage(
    map: Map<Ingredient, Int>,
) {
    private var data = map.toMutableMap()
    fun takeIngredientForPizza(pizza: Pizza) {
        pizza.ingredients.forEach { (ingredient, amount) ->
            val currentAmount = getRemainder(ingredient)
            if (currentAmount < amount) {
                error("ингредиента: ${ingredient.value} нет")
            }
            data.put(ingredient, currentAmount - amount)
        }
    }

    fun getRemainder(ingredient: Ingredient): Int {
        return data.get(ingredient) ?: error("такого ингредиента нет!")
    }

}

