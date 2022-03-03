package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    val pizzaOrder = pizzaStore.orderPizza("сардиния")
    val coffeeOrder = pizzaStore.orderCoffee("капучино")
    pizzaStore.executeOrder(pizzaOrder, coffeeOrder)
}