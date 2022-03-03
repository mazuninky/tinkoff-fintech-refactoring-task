package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.menu.MenuService
import ru.tinkoff.fintech.refactoring.products.Coffee
import ru.tinkoff.fintech.refactoring.store.PricesService
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

class Barista(
    menuService: MenuService? = null,
    priceService: PricesService? = null,
) : CafeWorker<Coffee>("Бариста", menuService, priceService) {

    override fun start(container: Order) = makeCoffee(container)

    override fun needToProcessOrder(order: Order): Boolean =
        order.type == MenuKind.COFFEE


    private fun makeCoffee(order: Order) {
        val coffee = getFoodByOrder(order) ?: error("Невозможно приготовить ${order.name}")
        val price = calcPrice(order)

        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${coffee.brewTime.seconds / 60} минут")
        val roundedPrice = "%.2f".format(price)
        println("[Бариста] Стоимость напитка: $roundedPrice")
    }
}