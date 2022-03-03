package ru.tinkoff.fintech.refactoring

class Storage(
    initial: Map<Ingredient, Int>,
) {
    private var current = initial.toMutableMap()

    fun takeIngredientForPizza(pizza: Pizza) {
        pizza.ingredients.forEach { (ingredient, amount) ->
            val currentAmount = getRemainder(ingredient)
            if (currentAmount < amount) {
                error("ингредиента: ${ingredient.value} нет")
            }
            current.put(ingredient, currentAmount - amount)
        }
    }

    fun getRemainder(ingredient: Ingredient): Int {
        return current.get(ingredient) ?: error("такого ингредиента нет!")
    }

}
