package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.store.PizzaStore

fun main() {
    val pizzaStore = PizzaStore()
    val pizzaOrder = pizzaStore.orderPizza("карбонара")
    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
    pizzaStore.executeOrder(pizzaOrder, coffeeOrder)
}