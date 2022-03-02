package ru.tinkoff.fintech.refactoring

class Storage(
    var data: MutableMap<Ingredient, Int>
) {
    fun takeIngredient(ingredient: Ingredient, amount: Int) {
        var curentAmout = data.get(ingredient) ?: error("такого ингредиента нет!")
        data.put(ingredient, curentAmout - amount)
    }

    fun getRemainder(ingredient: Ingredient): Int {
        return data.get(ingredient) ?: error("такого ингредиента нет!")
    }

}
