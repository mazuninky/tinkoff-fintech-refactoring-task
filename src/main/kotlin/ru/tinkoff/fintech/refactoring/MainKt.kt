package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    val pizzaCarbonara = PizzaCarbonara()
    val pizzaOrder = pizzaStore.orderPizza(pizzaCarbonara)
    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
    pizzaStore.executeOrder(pizzaOrder)
    pizzaStore.executeOrder(coffeeOrder)
}