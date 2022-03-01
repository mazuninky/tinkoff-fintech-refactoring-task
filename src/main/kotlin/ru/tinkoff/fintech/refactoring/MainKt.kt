package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    val coffeeStore = CoffeeStore()
    val pizzaOrder = pizzaStore.orderPizza("карбонара")
    val coffeeOrder = coffeeStore.orderCoffee("эспрессо")
    pizzaStore.executeOrder(pizzaOrder)
    coffeeStore.executeOrder(coffeeOrder)
}