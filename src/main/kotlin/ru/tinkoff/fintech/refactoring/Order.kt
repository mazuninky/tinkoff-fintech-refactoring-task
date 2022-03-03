package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
    val price: Double,
    val storage: Storage
)

data class CoffeeOrder(
    val number: Int,
    val coffee: Coffee,
    val price: Double

)
