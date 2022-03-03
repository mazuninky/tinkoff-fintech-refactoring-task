package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    pizzaStore.executeOrder(pizzaStore.orderPizza("карбонара"), pizzaStore.orderCoffee("эспрессо"))
}
