package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.store.PizzaCafe

fun main() {
    val pizzaCafe = PizzaCafe()
    val order = setOf(
        pizzaCafe.order(MenuKind.PIZZA, "карбонара"),
        pizzaCafe.order(MenuKind.COFFEE, "эспрессо"),
    )

    pizzaCafe.executeOrder(order)
}