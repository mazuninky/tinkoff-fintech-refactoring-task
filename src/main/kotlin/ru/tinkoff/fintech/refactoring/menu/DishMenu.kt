package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Dish

abstract class DishMenu(
    menu: Map<String, Dish>
) : Menu<Dish>(menu) {
    final override val menuKind: MenuKind
        get() = MenuKind.DISH
}