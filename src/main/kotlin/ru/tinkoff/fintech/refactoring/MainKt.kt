package ru.tinkoff.fintech.refactoring

fun main() {

    val pizzaCafe = PizzaCafe()

    val pizzaz = listOf("карбонара", "сардиния")

    val pizzaOrders = pizzaz.map { pizzaCafe.order(OrderType.PIZZA, it) }

    val coffees = listOf("эспрессо", "эспрессо".reversed())

    val coffeeOrders = coffees.map { pizzaCafe.order(OrderType.COFFEE, it) }

    val order = setOf(
        pizzaOrders, coffeeOrders
    ).flatten().toSet()

    pizzaCafe.executeOrder(order)

}