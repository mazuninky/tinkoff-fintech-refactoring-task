package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.MenuFactory
import ru.tinkoff.fintech.refactoring.menu.MenuFactoryImpl
import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.Barista
import ru.tinkoff.fintech.refactoring.store.employees.Cleaner
import ru.tinkoff.fintech.refactoring.store.employees.Cooker

class PizzaCafe(
    override val menuFactory: MenuFactory = MenuFactoryImpl()
) : Cafe(
    menuFactory,
    initWorkers(menuFactory)
) {

    companion object {
        private fun initWorkers(menuFactory: MenuFactory) = mapOf(
            Area.FOOD to setOf(
                Cooker(menuFactory),
                Barista(menuFactory),
            ),
            Area.OTHER to setOf(Cleaner())
        )
    }
}