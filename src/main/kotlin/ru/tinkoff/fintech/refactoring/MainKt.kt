package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    val pizzaOrder = pizzaStore.orderPizza("карбонара")
    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
    listOf(pizzaOrder, coffeeOrder).forEach(){
        it.executeOrder()
    }
}