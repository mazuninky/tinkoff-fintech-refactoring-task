package ru.tinkoff.fintech.refactoring.products.abstractProducts

import ru.tinkoff.fintech.refactoring.products.productsImpl.Ingredient

abstract class Dish(
    override val name: String,
    private val ingredients: MutableMap<Ingredient, Int> = mutableMapOf()
) : Food {
    /**
     * @return (ингредиент, кол-во)...
     */
    fun getIngredients() = ingredients.toList()

    override val price: Double
        get() = calcPrice()

    private fun calcPrice(): Double = ingredients.entries.sumOf {
        it.key.price * it.value
    }

    fun with(name: String, count: Double) = with(Ingredient(name, price))


    fun with(ingredient: Ingredient): Dish = with(ingredient, 1)

    fun with(ingredient: Ingredient, count: Int): Dish {
        ingredients.put(ingredient, count)
        return this
    }

}