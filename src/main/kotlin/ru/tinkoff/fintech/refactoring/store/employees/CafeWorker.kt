package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.Menu
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.products.Product
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

abstract class CafeWorker<T : Product>(
    final override val name: String,
    protected open val menu: Map<MenuKind, Menu<*>>
) : Employee<Order>() {

    override val area: Area
        get() = Area.FOOD

    fun checkForProcessingOrder(order: Order): Boolean = needToProcessOrder(order)

    fun getFoodByOrder(order: Order): T? = menu[order.type]?.get(order.name) as? T

    final override fun finish(container: Order) {
        println("[$name] заказ ${container.orderId} готов")
    }

    protected abstract fun needToProcessOrder(order: Order): Boolean
}