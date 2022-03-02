package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Ingredient

data class IngredientMenu(
    override val menu: Map<String, Ingredient>
) : Menu<Ingredient>(menu) {

    override val menuKind: MenuKind
        get() = MenuKind.INGREDIENT
}
