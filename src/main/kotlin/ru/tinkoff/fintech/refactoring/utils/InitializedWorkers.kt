package ru.tinkoff.fintech.refactoring.utils

import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.Barista
import ru.tinkoff.fintech.refactoring.store.employees.Cleaner
import ru.tinkoff.fintech.refactoring.store.employees.Cooker

class InitializedWorkers(
    private val initializedMenus: InitializedMenus = InitializedMenus()
) {
    val workers = mapOf(
        Area.FOOD to setOf(
            Cooker(initializedMenus.mainMenu),
            Barista(initializedMenus.mainMenu),
        ),
        Area.OTHER to setOf(Cleaner())
    )
}