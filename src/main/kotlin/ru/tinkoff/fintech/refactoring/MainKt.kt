package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    pizzaStore.makeNewOrder()
    val pizzaCarbonara = PizzaCarbonara()
    val pizzaOrder = pizzaStore.orderPizza(pizzaCarbonara)
    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
    val orderList1 = listOf(pizzaOrder, coffeeOrder)
    pizzaStore.executeOrder()
    pizzaStore.makeNewOrder()
    val coffeeOrder2 = pizzaStore.orderCoffee("капучино")
    val orderList2 = listOf(coffeeOrder2)
    pizzaStore.executeOrder()
}