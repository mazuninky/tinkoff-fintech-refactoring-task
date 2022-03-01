package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    pizzaStore.orderPizza("Карбонара".lowercase())
    pizzaStore.orderCoffee("капучино".lowercase())
}