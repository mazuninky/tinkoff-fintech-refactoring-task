package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.MenuFactory
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.CafeWorker
import ru.tinkoff.fintech.refactoring.store.employees.Employee
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

abstract class Cafe(
    protected open val menuFactory: MenuFactory,
    employees: Map<Area, Set<Employee<*>>> = mapOf(),
) {

    private val employees: MutableMap<Area, MutableSet<Employee<*>>> =
        employees.mapValues {
            for (value in it.value) {
                if (!it.key.correctWorkerClazz.isAssignableFrom(value::class.java)) {
                    throw IllegalStateException("Нельзя в данную область работы поставить работника \"${value.name}\"")
                }
            }
            it.value.toMutableSet()
        }.toMutableMap()

    fun addEmployee(area: Area, employee: Employee<*>) {
        if (!area.correctWorkerClazz.isAssignableFrom(employee::class.java)) {
            throw IllegalStateException("Нельзя в данную область работы поставить работника \"${employee.name}\"")
        }

        if (employees[area] == null) employees[area] = mutableSetOf(employee) else employees[area]!!.add(employee)
    }

    private var curOrderId = 0

    fun order(type: MenuKind, name: String): Order {
        val localMenu = menuFactory.getMenu(type) ?: error("Нет такого типа меню ($type)")
        val product = localMenu.menu[name] ?: error("В меню $type нет $name")
        val price = product.price ?: error("Невозможно заказать $name (нет в наличии)")
        val number = curOrderId++

        return Order(type, name, number, price)
    }

    fun executeOrder(orders: Set<Order>) {
        for (order in orders) {
            var correctEmployee: CafeWorker<*>? = null

            for (employee in employees[Area.FOOD]!!) {
                employee as CafeWorker<*>
                if (employee.checkForProcessingOrder(order)) {
                    correctEmployee = employee
                    break
                }
            }

            if (correctEmployee == null) error("Невозможно найти работника, который сможет приготовить заказ $order")
            correctEmployee.work(order)
        }
    }
}