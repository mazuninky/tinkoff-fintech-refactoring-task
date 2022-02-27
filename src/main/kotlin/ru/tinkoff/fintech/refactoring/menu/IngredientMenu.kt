package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.descriptions.IngredientDescr
import ru.tinkoff.fintech.refactoring.products.Ingredient

class IngredientMenu : Menu<Ingredient> {
    private val localMenu: Map<String, Ingredient> = mapOf(
        "яйца" to 3.48,
        "бекон" to 6.48,
        "тесто" to 1.00,
        "томат" to 1.53,
        "оливки" to 1.53,
        "сыр" to 0.98,
        "пармезан" to 3.98,
        "грибы" to 3.34,
        "спаржа" to 3.34,
        "мясное ассорти" to 9.38,
        "вяленая говядина" to 12.24,
    ).mapValues { Ingredient(IngredientDescr(it.key), it.value) }

    override val menu: Map<String, Ingredient>
        get() = localMenu
}
