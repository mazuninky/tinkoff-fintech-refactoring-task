package ru.tinkoff.fintech.refactoring

data class Coffee(
    override val name: String,
    override val price: Double,
    val brewTimeInMinutes: Int
) : Product

class CoffeeList: ProductList<Coffee>() {
    fun getCoffeeByName(name: String): Coffee {
        return getProductByName(name, "Неизвестный вид кофе: $name")
    }
}