package ru.tinkoff.fintech.refactoring


enum class Pizza(val value: String, val ingredients: Array<Pair<Ingredient, Int>>) {
    Carbonara(
        "карбонара",
        arrayOf(
            Pair(Ingredient.EGG, 1), Pair(Ingredient.BECKON, 2), Pair(Ingredient.DOUGH, 1), Pair(Ingredient.CHEESE, 2)
        )
    ),
    Marinara(
        "маринара", arrayOf(Pair(Ingredient.TOMATO, 2), Pair(Ingredient.OLIVES, 3), Pair(Ingredient.DOUGH, 1))
    ),
    Sardinya(
        "сардиния",
        arrayOf(
            Pair(Ingredient.SALAMI, 3),
            Pair(Ingredient.OLIVES, 1),
            Pair(Ingredient.DOUGH, 1),
            Pair(Ingredient.CHEESE, 3)
        )
    ),
    Valtellina(
        "вальтеллина",
        arrayOf(
            Pair(Ingredient.BEEFJERKY, 1),
            Pair(Ingredient.GRASS, 1),
            Pair(Ingredient.DOUGH, 1),
            Pair(Ingredient.PARMESAN, 2)
        )
    ),
    Peasant(
        "крестьянская",
        arrayOf(
            Pair(Ingredient.MUSHROOM, 3),
            Pair(Ingredient.TOMATO, 1),
            Pair(Ingredient.DOUGH, 1),
            Pair(Ingredient.ASPARAGUS, 1),
            Pair(Ingredient.MEAT, 1)
        )
    ),
}


fun isPizzaAvailable(name: String): Pizza? {
    return Pizza.values().find { it.value == name }
}

