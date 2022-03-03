package ru.tinkoff.fintech.refactoring

data class Pizza(
    val name: String
)

fun getIngredient(pizza: Pizza): List<Pair<Ingredient, Int>> {
    return when (pizza.name) {
        "карбонара" -> listOf(
            Ingredient.EGG to 1,
            Ingredient.BACON to 2,
            Ingredient.DOUGH to 1,
            Ingredient.CHEESE to 2
        )
        "маринара" -> listOf(
            Ingredient.TOMATO to 2,
            Ingredient.OLIVES to 3,
            Ingredient.DOUGH to 1
        )
        "сардиния" -> listOf(
            Ingredient.SALAMI to 3,
            Ingredient.OLIVES to 1,
            Ingredient.DOUGH to 1,
            Ingredient.CHEESE to 3
        )
        "вальтеллина" -> listOf(
            Ingredient.BEEFJERKY to 1,
            Ingredient.GREENS to 1,
            Ingredient.DOUGH to 1,
            Ingredient.PARMESAN to 2
        )
        "крестьянская" -> listOf(
            Ingredient.MUSHROOMS to 3,
            Ingredient.TOMATO to 1,
            Ingredient.DOUGH to 1,
            Ingredient.ASPARAGUS to 1,
            Ingredient.COULDCUTS to 1
        )
        else -> emptyList()
    }
}