package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.MenuService
import ru.tinkoff.fintech.refactoring.products.Product
import ru.tinkoff.fintech.refactoring.store.PricesService
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

abstract class CafeWorker<T : Product>(
    final override val name: String,
    open var menuService: MenuService? = null,
    open var priceService: PricesService? = null,
) : Employee<Order>() {

    override val area: Area
        get() = Area.FOOD

    fun checkForProcessingOrder(order: Order): Boolean = needToProcessOrder(order)

    fun getFoodByOrder(order: Order): T? {
        menuService
            ?: error("Невозможно найти в меню \"${order.name}\", т. к. у работника ($name) нет доступа к необходимым данным")
        return menuService!!.getMenu(order.type)?.get(order.name) as T?
    }

    fun calcPrice(order: Order): Double? {
        priceService
            ?: error("Невозможно рассчитать цену \"${order.name}, т. к. у работника ($name) нет доступа к необходимым данным")

        val food = getFoodByOrder(order) ?: error("Невозможно рассчитать цену ${order.name}")
        return priceService!!.calcPrice(order.type, food)
    }

    final override fun finish(container: Order) {
        println("[$name] заказ ${container.orderId} готов")
    }

    protected abstract fun needToProcessOrder(order: Order): Boolean
}