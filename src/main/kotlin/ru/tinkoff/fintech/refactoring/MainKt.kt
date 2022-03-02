package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    pizzaStore.executeOrderBarista("эспрессо")
    pizzaStore.executeOrderBarista("Капучино")
    pizzaStore.executeCleaning()
    println(pizzaStore.executeOrderPizzaMaker("маринара"))
    println(pizzaStore.executeOrderPizzaMaker("Крестьянская"))
    pizzaStore.executeOrderBarista("")
}