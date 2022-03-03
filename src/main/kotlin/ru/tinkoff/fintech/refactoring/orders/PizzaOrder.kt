package ru.tinkoff.fintech.refactoring.orders

import ru.tinkoff.fintech.refactoring.Pizza

data class PizzaOrder(
    val id: Int,
    val pizza: Pizza
)