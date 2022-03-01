package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Dish

abstract class DishMenu(
    protected open val localMenu: Map<String, Dish> = mapOf()
) : Menu<Dish> {
    override val menu: Map<String, Dish>
        get() = localMenu
}