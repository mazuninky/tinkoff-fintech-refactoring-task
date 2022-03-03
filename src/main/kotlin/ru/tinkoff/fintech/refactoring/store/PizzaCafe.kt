package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.MenuService
import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.Employee

class PizzaCafe(
    menuService: MenuService,
    pricesService: PricesService,
    employees: Map<Area, Set<Employee<*>>> = mapOf(),
) : Cafe(
    menuService,
    pricesService,
    employees,
)