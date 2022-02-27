package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.menu.CoffeeMenu
import ru.tinkoff.fintech.refactoring.menu.PizzaMenu
import ru.tinkoff.fintech.refactoring.menu.MenuFactory

fun main() {
//    val pizzaStore = PizzaStore()
//    val pizzaOrder = pizzaStore.orderPizza("карбонара")
//    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
//    pizzaStore.executeOrder(pizzaOrder, coffeeOrder)
    println(MenuFactory.getMenu("coffee", CoffeeMenu::class.java).menu["эспрессо"])
}