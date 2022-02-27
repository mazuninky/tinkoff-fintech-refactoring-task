package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.MenuFactory
import ru.tinkoff.fintech.refactoring.menu.MenuFactoryImpl
import ru.tinkoff.fintech.refactoring.store.employees.Barista
import ru.tinkoff.fintech.refactoring.store.employees.Cooker

class PizzaCafe(
    override val menuFactory: MenuFactory = MenuFactoryImpl()
) : Cafe(
    menuFactory,
    initWorkers(menuFactory)
) {

    companion object {
        private fun initWorkers(menuFactory: MenuFactory) = setOf(
            Cooker(menuFactory),
            Barista(menuFactory),
        )
    }
}