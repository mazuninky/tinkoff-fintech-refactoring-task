package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.Ingredient.*

enum class Pizza(
    val value: String,
    val ingredients: Map<Ingredient, Int>,
) {
    Carbonara(
        value = "карбонара",
        ingredients = mapOf(
            EGG to 1,
            BACON to 2,
            DOUGH to 1,
            CHEESE to 2
        )
    ),
    Marinara(
        value = "маринара",
        ingredients = mapOf(
            TOMATO to 2,
            OLIVES to 3,
            DOUGH to 1
        )
    ),
    Sardinya(
        value = "сардиния",
        ingredients = mapOf(
            SALAMI to 3,
            OLIVES to 1,
            DOUGH to 1,
            CHEESE to 3
        )
    ),
    Valtellina(
        value = "вальтеллина",
        ingredients = mapOf(
            BEEF_JERKY to 1,
            LETTUCE to 1,
            DOUGH to 1,
            PARMESAN to 2
        )
    ),
    Peasant(
        value = "крестьянская",
        ingredients = mapOf(
            MUSHROOM to 3,
            TOMATO to 1,
            DOUGH to 1,
            ASPARAGUS to 1,
            MEAT to 1
        )
    );

    val price: Double = ingredients.map { (ingredients, amount) -> ingredients.price * amount }.sum()

    companion object {
        fun findPizza(name: String): Pizza? {
            val lowercaseName = name.lowercase()
            return Pizza.values().find { it.value == lowercaseName }
        }
    }

}


