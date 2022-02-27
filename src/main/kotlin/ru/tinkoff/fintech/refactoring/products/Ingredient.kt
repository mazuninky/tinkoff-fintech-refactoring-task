package ru.tinkoff.fintech.refactoring.products

import ru.tinkoff.fintech.refactoring.products.descriptions.IngredientDescr

class Ingredient(
    descr: IngredientDescr,
    override val price: Double,
) : Product<IngredientDescr>(descr, price, true) {
    override fun toString(): String {
        return description.name
    }
}