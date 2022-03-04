package ru.tinkoff.fintech.refactoring

fun main() {

    val pizzaCafe = PizzaCafe()

    val pizzaz = listOf("карбонара", "сардиния").map { OrderType.PIZZA to it }

    val coffees = listOf("эспрессо", "эспрессо".reversed()).map { OrderType.COFFEE to it }

    val order = setOf(
        pizzaz,
        coffees,
    ).flatten().toSet()

    pizzaCafe.executeOrders(order)

}