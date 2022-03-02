package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.Menu
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.CafeWorker
import ru.tinkoff.fintech.refactoring.store.employees.Employee
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

abstract class Cafe(
    protected open var menu: Map<MenuKind, Menu<*>>,
    employeesPerArea: Map<Area, Set<Employee<*>>> = mapOf(),
) {

    private val employeesPerArea: MutableMap<Area, MutableSet<Employee<*>>> =
        employeesPerArea.mapValues { it.value.toMutableSet() }.toMutableMap()

    init {
        employeesPerArea.forEach { (area, employees) ->
            employees.forEach { employee ->
                if (employee.area != area) throw IllegalStateException("В область работы $area нельзя поставить работника \"${employee.name}\"")
            }
        }
    }

    private var curOrderId = 0

    fun order(type: MenuKind, name: String): Order {
        val localMenu = menu[type] ?: error("Нет такого типа меню ($type)")
        val product = localMenu.menu[name] ?: error("В меню $type нет $name")
        val price = product.price ?: error("Невозможно заказать $name (нет в наличии)")
        val number = curOrderId++

        return Order(type, name, number, price)
    }

    fun executeOrder(orders: Set<Order>) {
        orders.forEach { order ->
            (employeesPerArea.getValue(Area.FOOD)
                .mapNotNull { it as? CafeWorker<*> }
                .find { it.checkForProcessingOrder(order) }
                ?: error("Невозможно найти работника, который сможет приготовить заказ $order")
                    ).work(order)
        }
    }
}