package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()

    initProducts(pizzaStore)

    val pizzaOrder = pizzaStore.orderPizza("карбонара")
    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
    pizzaStore.executeOrder(pizzaOrder)
    pizzaStore.executeOrder(coffeeOrder)

    pizzaStore.coffeeMenu.add(Coffee("американо", 4.50, 5))
    val coffeeOrder2 = pizzaStore.orderCoffee("американо")
    pizzaStore.executeOrder(coffeeOrder2)

    pizzaStore.pizzaMenu.add(
        Pizza("вальтеллина", listOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2)
        ))
}