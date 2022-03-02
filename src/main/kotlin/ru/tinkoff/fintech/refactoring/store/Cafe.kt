package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.Menu
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.CafeWorker
import ru.tinkoff.fintech.refactoring.store.employees.Employee
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

abstract class Cafe(
    protected open var menu: Map<MenuKind, Menu<*>>,
    employees: Map<Area, Set<Employee<*>>> = mapOf(),
) {

    private val employees: MutableMap<Area, MutableSet<Employee<*>>> =
        employees.mapValues { entry ->
            entry.value.onEach { employee ->
                if (entry.key != employee.area) {
                    throw IllegalStateException("Нельзя в данную область работы поставить работника \"${employee.name}\"")
                }
            }.toMutableSet()
        }.toMutableMap()

    private var curOrderId = 0

    fun order(type: MenuKind, name: String): Order {
        val localMenu = menu[type] ?: error("Нет такого типа меню ($type)")
        val product = localMenu.menu[name] ?: error("В меню $type нет $name")
        val price = product.getPrice().invoke() ?: error("Невозможно заказать $name (нет в наличии)")
        val number = curOrderId++

        return Order(type, name, number, price)
    }

    fun executeOrder(orders: Set<Order>) {
        orders.forEach { order ->

            val correctEmployee: CafeWorker<*> = employees.getValue(Area.FOOD).find { employee ->
                employee as CafeWorker<*>
                employee.checkForProcessingOrder(order)
            } as? CafeWorker<*> ?: error("Невозможно найти работника, который сможет приготовить заказ $order")

            correctEmployee.work(order)
        }
    }
}