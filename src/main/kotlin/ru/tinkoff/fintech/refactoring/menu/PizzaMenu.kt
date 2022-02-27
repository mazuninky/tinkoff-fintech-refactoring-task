package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.descriptions.DishDescr
import ru.tinkoff.fintech.refactoring.products.Dish

class PizzaMenu : DishMenu(
    initPizzas()
) {
    companion object {
        private fun initPizzas(): Map<String, Dish> =
            mapOf(
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
            ).mapValues {
                val recipe = it.value
                val description = DishDescr(it.key, recipe)
                Dish(description)
            }
    }
}