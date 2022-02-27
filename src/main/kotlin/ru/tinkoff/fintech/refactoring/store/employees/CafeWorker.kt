package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.MenuFactory
import ru.tinkoff.fintech.refactoring.products.Product
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

abstract class CafeWorker<FOOD_T : Product<*>>(
    final override val name: String,
    val menuFactory: MenuFactory
) : Employee<Order> {

    final override fun finish(container: Order) {
        println("[$name] заказ ${container.orderId} готов")
    }

    protected abstract val patternForOrder: (order: Order) -> Boolean

    fun checkForProcessingOrder(order: Order): Boolean = patternForOrder(order)

    fun getFoodByOrder(order: Order): FOOD_T {
        val food = menuFactory.getMenu(order.type)?.menu?.get(order.name)
        return food as FOOD_T
    }
}