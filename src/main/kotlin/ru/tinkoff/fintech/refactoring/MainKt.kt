package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()

    pizzaStore.executeOrderCoffee("эспрессо")
    pizzaStore.executeOrderCoffee("Капучино")
    pizzaStore.executeCleaning()
    pizzaStore.executeOrderPizza("маринара")
    pizzaStore.executeOrderPizza("Крестьянская")
    pizzaStore.executeOrderCoffee("")
}