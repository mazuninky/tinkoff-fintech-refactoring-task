package ru.tinkoff.fintech.refactoring.factories

import ru.tinkoff.fintech.refactoring.products.productsImpl.Ingredient

class IngredientStore : Store<Ingredient>(
    mapOf(
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
    ).map {
        Pair(it.key, Ingredient(it.key, it.value))
    }.toMap().toMutableMap()
)
