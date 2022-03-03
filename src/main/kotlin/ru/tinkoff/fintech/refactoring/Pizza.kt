package ru.tinkoff.fintech.refactoring

data class Ingredient(
    val name: String,
    val price: Double
)

data class Pizza(
    val name: String
) {
    val ingredients: List<Pair<Ingredient, Int>> = getIngredient(this)
}

fun getIngredient(pizza: Pizza): List<Pair<Ingredient, Int>> {
    return when (pizza.name) {
        "карбонара" -> listOf(Ingredient("яйца", 3.48) to 1,
                                Ingredient("бекон", 6.48) to 2,
                                Ingredient("тесто", 1.00) to 1,
                                Ingredient("сыр", 0.98) to 2)

        "маринара" -> listOf(Ingredient("томат", 1.53) to 2,
                                Ingredient("оливки", 1.53) to 3,
                                Ingredient("тесто", 1.00) to 1)

        "сардиния" -> listOf(Ingredient("салями", 3.48) to 3,
                                Ingredient("оливки", 1.53) to 1,
                                Ingredient("тесто", 1.00) to 1,
                                Ingredient("сыр", 0.98) to 3)

        "вальтеллина" -> listOf(Ingredient("вяленая говядина", 12.24) to 1,
                                Ingredient("зелень", 0.48) to 1,
                                Ingredient("тесто", 1.00) to 1,
                                Ingredient("пармезан", 3.98) to 2)

        "крестьянская" -> listOf(Ingredient("грибы", 3.48) to 3,
                                Ingredient("томат", 1.53) to 1,
                                Ingredient("тесто", 1.00) to 1,
                                Ingredient("спаржа", 3.34) to 1,
                                Ingredient("мясное ассорти", 9.38) to 1)
        else -> emptyList()
    }
}