package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.factories.PizzaStore
import ru.tinkoff.fintech.refactoring.factories.StoreFactory

fun main() {
//    val pizzaStore = PizzaStore()
//    val pizzaOrder = pizzaStore.orderPizza("карбонара")
//    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
//    pizzaStore.executeOrder(pizzaOrder, coffeeOrder)
    println(StoreFactory.getStore("pizzas", PizzaStore::class.java).forceGet("карбонара"))
}