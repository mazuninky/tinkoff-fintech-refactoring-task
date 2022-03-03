package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.MenuKind

class PricesRepository {
    fun getPricesByMenuKind(menuKind: MenuKind): MutableMap<String, Double>? = prices[menuKind]

    private var prices: Map<MenuKind, MutableMap<String, Double>> = mutableMapOf(
        MenuKind.COFFEE to mutableMapOf(
            "эспрессо" to 5.0,
            "капучино" to 3.48
        ),
        MenuKind.INGREDIENT to mutableMapOf(
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
        )
    )
}