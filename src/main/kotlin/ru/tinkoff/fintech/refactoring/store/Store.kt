package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.MenuFactory

abstract class Store<T>(
    private val menuFactory: MenuFactory
) {
    var curOrderNumber = 0

    data class Order(
        val type: String,
        val name: String,
        val number: Int,
        val price: Double
    )

    fun order(type: String, name: String): Order {
        val localMenu = menuFactory.getMenu(type) ?: error("Нет такого типа меню ($type)")
        val product = localMenu.menu[name] ?: error("В меню $type нет $name")
        val price = product.price ?: error("Невозможно заказать $name (нет в наличии)")
        val number = curOrderNumber++

        return Order(type, name, number, price)
    }
}