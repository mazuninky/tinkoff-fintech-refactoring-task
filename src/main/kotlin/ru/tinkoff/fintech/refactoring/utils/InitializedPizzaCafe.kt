package ru.tinkoff.fintech.refactoring.utils

import ru.tinkoff.fintech.refactoring.store.PizzaCafe

class InitializedPizzaCafe(
    val initializedMenus: InitializedMenus = InitializedMenus(),
    initializedWorkers: InitializedWorkers = InitializedWorkers(initializedMenus)
) {
    val pizzaCafe = PizzaCafe(initializedMenus.mainMenu, initializedWorkers.workers)
}