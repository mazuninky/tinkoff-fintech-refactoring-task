package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()

    val pizzaOrder = pizzaStore.orderPizza("карбонара")
    pizzaStore.pizzaKitchen.executeOrder(pizzaOrder)


    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
    pizzaStore.coffeeShop.executeOrder(coffeeOrder)
}
