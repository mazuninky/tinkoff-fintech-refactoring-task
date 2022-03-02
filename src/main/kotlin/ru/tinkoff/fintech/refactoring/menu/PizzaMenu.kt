package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Dish

data class PizzaMenu(
    override val menu: Map<String, Dish>
) : DishMenu(menu)