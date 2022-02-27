package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.menu.CoffeeMenu
import ru.tinkoff.fintech.refactoring.menu.MenuFactoryImpl
import ru.tinkoff.fintech.refactoring.store.PizzaCafe
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

fun main() {
    val pizzaCafe = PizzaCafe()
    val order = setOf(
        pizzaCafe.order("pizza", "карбонара"),
        pizzaCafe.order("coffee", "эспрессо"),
    )

    pizzaCafe.executeOrder(order)
//    val pizzaStore = PizzaStore()
//    val pizzaOrder = pizzaStore.orderPizza("карбонара")
//    val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
//    pizzaStore.executeOrder(pizzaOrder, coffeeOrder)
//    println(MenuFactoryImpl.getMenu("coffee", CoffeeMenu::class.java)?.menu?.get("эспрессо"))
}