package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Coffee
import ru.tinkoff.fintech.refactoring.products.Dish
import ru.tinkoff.fintech.refactoring.products.Ingredient
import java.time.Duration

class MenuRepository {
    val mainMenu: Map<MenuKind, Menu<*>> = mapOf(
        MenuKind.DISH to PizzaMenu(mapOf(
            "карбонара" to mapOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2),
            "маринара" to mapOf("томат" to 2, "оливки" to 3, "тесто" to 1),
            "сардиния" to mapOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3),
            "вальтеллина" to mapOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2),
            "крестьянская" to mapOf(
                "грибы" to 3,
                "томат" to 1,
                "тесто" to 1,
                "спаржа" to 1,
                "мясное ассорти" to 1
            ),
        ).mapValues { Dish(it.key, it.value) }
        ),

        MenuKind.INGREDIENT to IngredientMenu(listOf(
            "яйца",
            "бекон",
            "тесто",
            "томат",
            "оливки",
            "сыр",
            "пармезан",
            "грибы",
            "спаржа",
            "мясное ассорти",
            "вяленая говядина",
        ).associateWith { Ingredient(it) }),

        MenuKind.COFFEE to CoffeeMenu(listOf(
            Coffee("эспрессо", Duration.ofMinutes(5)),
            Coffee("капучино", Duration.ofMinutes(6)),
        ).associateBy { it.name })
    )
}