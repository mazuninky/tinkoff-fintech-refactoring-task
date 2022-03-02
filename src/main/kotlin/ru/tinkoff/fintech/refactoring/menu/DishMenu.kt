package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Dish

abstract class DishMenu(
    override val menu: Map<String, Dish>
) : Menu<Dish> {
    final override val menuKind: MenuKind
        get() = MenuKind.DISH
}