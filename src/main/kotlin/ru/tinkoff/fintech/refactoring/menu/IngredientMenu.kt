package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Ingredient

data class IngredientMenu(
    private val localMenu: Map<String, Ingredient>
) : Menu<Ingredient> {
    override val menu: Map<String, Ingredient>
        get() = localMenu

    override val menuKind: MenuKind
        get() = MenuKind.INGREDIENT
}
