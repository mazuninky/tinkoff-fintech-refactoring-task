package ru.tinkoff.fintech.refactoring.products

data class Ingredient(
    override val name: String,
    val price: Double?,
) : Product(name, true) {
    override fun getPrice(): () -> Double? = { price }

    override fun toString(): String {
        return name
    }
}