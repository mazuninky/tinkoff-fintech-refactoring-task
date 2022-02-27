package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.MenuFactory
import ru.tinkoff.fintech.refactoring.store.employees.CafeWorker
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

abstract class Cafe(
    protected open val menuFactory: MenuFactory,
    employees: Set<CafeWorker<*>> = emptySet(),
) {
    private val employees: MutableSet<CafeWorker<*>> = employees.toMutableSet()

    fun addEmployee(employee: CafeWorker<*>) {
        employees.add(employee)
    }

    private var curOrderId = 0

    fun order(type: String, name: String): Order {
        val localMenu = menuFactory.getMenu(type) ?: error("Нет такого типа меню ($type)")
        val product = localMenu.menu[name] ?: error("В меню $type нет $name")
        val price = product.price ?: error("Невозможно заказать $name (нет в наличии)")
        val number = curOrderId++

        return Order(type, name, number, price)
    }

    fun executeOrder(orders: Set<Order>) {
        for (order in orders) {
            var correctEmployee: CafeWorker<*>? = null

            for (employee in employees) {
                if (employee.checkForProcessingOrder(order)) {
                    correctEmployee = employee
                    break
                }
            }

            if (correctEmployee == null) error("Невозможно найти работника, который сможет приготовить заказ $order")
            correctEmployee.start(order)
        }
    }
}