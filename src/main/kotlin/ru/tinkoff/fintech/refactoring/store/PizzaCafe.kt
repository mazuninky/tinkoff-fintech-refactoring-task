package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.Menu
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.Employee

class PizzaCafe(
    override var menu: Map<MenuKind, Menu<*>>,
    employees: Map<Area, Set<Employee<*>>> = mapOf(),
) : Cafe(
    menu,
    employees,
) {
}