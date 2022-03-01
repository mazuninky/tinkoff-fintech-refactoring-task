package ru.tinkoff.fintech.refactoring.products

class Dish(
    override val name: String,
    val recipe: Map<String, Int>,
    private val getPriceWay: () -> Double?,
) : Product(name, true) {
    override fun getPrice(): () -> Double? = getPriceWay

    override fun toString(): String {
        return "{ $name : $recipe }"
    }
}