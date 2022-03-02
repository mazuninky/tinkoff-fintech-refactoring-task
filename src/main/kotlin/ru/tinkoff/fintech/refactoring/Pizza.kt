package ru.tinkoff.fintech.refactoring

enum class Pizza(val value: String, val ingredients: Map<Ingredient, Int>) {
    Carbonara(
        value = "карбонара",
        ingredients = mapOf(
            (Ingredient.EGG to 1), (Ingredient.BECKON to 2), (Ingredient.DOUGH to 1), (Ingredient.CHEESE to 2)
        )
    ),
    Marinara(
        value = "маринара",
        ingredients = mapOf((Ingredient.TOMATO to 2), (Ingredient.OLIVES to 3), (Ingredient.DOUGH to 1))
    ),
    Sardinya(
        value = "сардиния",
        ingredients = mapOf(
            (Ingredient.SALAMI to 3),
            (Ingredient.OLIVES to 1),
            (Ingredient.DOUGH to 1),
            (Ingredient.CHEESE to 3)
        )
    ),
    Valtellina(
        value = "вальтеллина",
        ingredients = mapOf(
            (Ingredient.BEEFJERKY to 1),
            (Ingredient.GRASS to 1),
            (Ingredient.DOUGH to 1),
            (Ingredient.PARMESAN to 2)
        )
    ),
    Peasant(
        value = "крестьянская",
        ingredients = mapOf(
            (Ingredient.MUSHROOM to 3),
            (Ingredient.TOMATO to 1),
            (Ingredient.DOUGH to 1),
            (Ingredient.ASPARAGUS to 1),
            (Ingredient.MEAT to 1)
        )
    );

    companion object {
        fun isPizzaAvailable(name: String): Pizza? {
            return Pizza.values().find { it.value == name }
        }
    }

}

