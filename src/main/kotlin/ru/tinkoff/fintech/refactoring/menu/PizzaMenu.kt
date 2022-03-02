package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Dish

data class PizzaMenu(
    override val localMenu: Map<String, Dish>,
) : DishMenu(localMenu) {
    override val menuKind: MenuKind
        get() = MenuKind.DISH
}