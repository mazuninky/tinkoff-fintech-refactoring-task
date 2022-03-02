package ru.tinkoff.fintech.refactoring

class Storage(
    var data: MutableMap<Ingredient, Int>
) {
    fun takeIngredient(ingredient: Ingredient, amount: Int) {
        val currentAmount = getRemainder(ingredient)
        if (currentAmount < amount) {
            error("ингредиента: ${ingredient.value} нет")
        }
        data.put(ingredient, currentAmount - amount)
    }

    fun getRemainder(ingredient: Ingredient): Int {
        return data.get(ingredient) ?: error("такого ингредиента нет!")
    }

}
