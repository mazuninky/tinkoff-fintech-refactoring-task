package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()

    pizzaStore.executeOrderBarista("эспрессо")
    pizzaStore.executeOrderBarista("Капучино")
    pizzaStore.executeCleaning()
    pizzaStore.executeOrderPizzaMaker("маринара")
    pizzaStore.executeOrderPizzaMaker("Крестьянская")
    pizzaStore.executeOrderBarista("")
}