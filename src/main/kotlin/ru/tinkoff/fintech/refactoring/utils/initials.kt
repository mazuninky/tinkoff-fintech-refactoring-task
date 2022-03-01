package ru.tinkoff.fintech.refactoring.utils

import ru.tinkoff.fintech.refactoring.menu.CoffeeMenu
import ru.tinkoff.fintech.refactoring.menu.IngredientMenu
import ru.tinkoff.fintech.refactoring.products.Coffee
import ru.tinkoff.fintech.refactoring.products.Ingredient
import java.time.Duration

fun initIngredientMenu(): IngredientMenu {
    val menu: Map<String, Ingredient> = mapOf(
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
    ).mapValues { Ingredient(it.key, it.value) }

    return IngredientMenu(menu)
}

fun initCoffee(): CoffeeMenu {
    val localMenu = setOf(
        Coffee("эспрессо", Duration.ofMinutes(5), 5.0),
        Coffee("капучино", Duration.ofMinutes(6), 3.48),
    ).associateBy { it.name }
    return CoffeeMenu(localMenu)
}

fun getGettingDishPriceWay(getIngredient: (String) -> Ingredient?): (Map<String, Int>) -> Double? = {

    try {
        it
            .mapKeys { getIngredient(it.key) ?: throw IllegalStateException("Невозможно определить цену ${it.key} ") }
            .entries.fold(0.0) { acc, entry ->
                val ingredientPrice = entry.key.getPrice().invoke()
                    ?: throw IllegalStateException("Невозможно определить цену ${entry.key.name} ")
                acc + ingredientPrice * entry.value
            }
    } catch (e: IllegalStateException) {
        null
    }
}