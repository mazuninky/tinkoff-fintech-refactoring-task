package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.Menu
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.products.Product
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

abstract class CafeWorker<FOOD_T : Product>(
    final override val name: String,
    protected open val menu: Map<MenuKind, Menu<*>>
) : Employee<Order> {

    final override fun finish(container: Order) {
        println("[$name] заказ ${container.orderId} готов")
    }

    protected abstract val patternForOrder: (order: Order) -> Boolean

    fun checkForProcessingOrder(order: Order): Boolean = patternForOrder(order)

    fun getFoodByOrder(order: Order): FOOD_T? = menu[order.type]?.get(order.name) as? FOOD_T
}