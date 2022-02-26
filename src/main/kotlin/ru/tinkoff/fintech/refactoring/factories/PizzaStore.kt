package ru.tinkoff.fintech.refactoring.factories

import ru.tinkoff.fintech.refactoring.products.productsImpl.Pizza

class PizzaStore : Store<Pizza>(
    initPizzas()
) {
    companion object {
        private fun initPizzas(): MutableMap<String, Pizza> {
            val pizzasDescr = mapOf(
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
            )

            val ingredientStore = StoreFactory.getStore("ingredients", IngredientStore::class.java)

            return pizzasDescr.mapValues {
                Pizza(it.key,
                    it.value.mapKeys { ingredient ->
                        ingredientStore.forceGet(ingredient.key)
                    }
                )
            }.toMutableMap()
        }
    }
}