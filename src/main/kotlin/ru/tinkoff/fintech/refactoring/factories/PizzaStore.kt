package ru.tinkoff.fintech.refactoring.factories

import ru.tinkoff.fintech.refactoring.products.productsImpl.Pizza

class PizzaStore : Store<Pizza>(
    mutableMapOf(
        Pizza("карбонара", mutableMapOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2))
    )
)