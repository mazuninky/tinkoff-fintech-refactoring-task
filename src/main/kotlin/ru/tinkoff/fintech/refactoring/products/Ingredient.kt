package ru.tinkoff.fintech.refactoring.products

class Ingredient(
    override val name: String,
    private var price: Double?,
) : Product(name, true) {

    fun setPrice(price: Double?) {
        this.price = price
    }

    override fun getPrice(): () -> Double? = { price }

    override fun toString(): String {
        return name
    }
}