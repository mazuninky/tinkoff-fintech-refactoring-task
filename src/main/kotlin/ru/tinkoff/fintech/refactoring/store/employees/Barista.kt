package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.MenuFactory
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.products.Coffee
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

class Barista(
    menuFactory: MenuFactory,
) : CafeWorker<Coffee>("Бариста", menuFactory) {

    override fun start(container: Order) = makeCoffee(container)

    override val patternForOrder: (order: Order) -> Boolean
        get() = { order: Order ->
            order.type == MenuKind.COFFEE
        }

    private fun makeCoffee(order: Order) {
        val coffee = getFoodByOrder(order)
        val orderId = order.orderId
        println("[Бариста] Готовлю напиток: ${coffee.description.name}")
        println("[Бариста] Время приготовления: ${coffee.description.brewTime.seconds / 60} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")
    }
}