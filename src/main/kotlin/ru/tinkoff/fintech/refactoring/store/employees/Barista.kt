package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.Menu
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.products.Coffee
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

class Barista(
    override val menu: Map<MenuKind, Menu<*>>,
) : CafeWorker<Coffee>("Бариста", menu) {

    override fun start(container: Order) = makeCoffee(container)

    override fun needToProcessOrder(order: Order): Boolean =
        order.type == MenuKind.COFFEE


    private fun makeCoffee(order: Order) {
        val coffee = getFoodByOrder(order) ?: error("Невозможно приготовить ${order.name}")

        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${coffee.brewTime.seconds / 60} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")
    }
}