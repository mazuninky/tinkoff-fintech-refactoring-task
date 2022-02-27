package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.store.PizzaCafe

fun main() {
    val pizzaCafe = PizzaCafe()
    val order = setOf(
        pizzaCafe.order("pizza", "карбонара"),
        pizzaCafe.order("coffee", "эспрессо"),
    )

    pizzaCafe.executeOrder(order)
}