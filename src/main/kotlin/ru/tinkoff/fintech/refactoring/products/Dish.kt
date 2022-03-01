package ru.tinkoff.fintech.refactoring.products

data class Dish(
    override val name: String,
    val recipe: Map<String, Int>,
    val getPrice: (Map<String, Int>) -> Double?,
) : Product(name, true) {
    override fun getPrice(): () -> Double? = { getPrice(recipe) }

    override fun toString(): String {
        return "{ $name : $recipe }"
    }
}