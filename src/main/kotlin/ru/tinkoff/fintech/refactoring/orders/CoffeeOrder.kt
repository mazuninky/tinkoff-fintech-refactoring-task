package ru.tinkoff.fintech.refactoring.orders

import ru.tinkoff.fintech.refactoring.Coffee

data class CoffeeOrder(
    val id: Int,
    val coffee: Coffee
)