package ru.tinkoff.fintech.refactoring.products

class Ingredient(
    override val name: String,
    var localPrice: Double?,
) : Product(name, true) {

    fun setPrice(localPrice: Double?) {
        this.localPrice = localPrice
    }

    override val price: Double?
        get() = localPrice

    override fun toString(): String {
        return name
    }
}