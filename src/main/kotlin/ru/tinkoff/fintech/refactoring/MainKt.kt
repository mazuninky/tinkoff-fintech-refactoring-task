package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    val pizzaOrder = pizzaStore.orderPizza("карбонара")
    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
    pizzaStore.pizzaDepartment.executeOrder(pizzaOrder)
    pizzaStore.coffeeDepartment.executeOrder(coffeeOrder)
}