package ru.tinkoff.fintech.refactoring.utils

import ru.tinkoff.fintech.refactoring.menu.Menu
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.products.Product
import ru.tinkoff.fintech.refactoring.store.PizzaCafe
import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.Employee
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.ContainerForWork

class InitializedPizzaCafe(
    mainMenu: Map<MenuKind, Menu<out Product>> = InitializedMenus().mainMenu,
    workers: Map<Area, Set<Employee<out ContainerForWork>>> = InitializedWorkers().workers
) {
    val pizzaCafe = PizzaCafe(mainMenu, workers)
}