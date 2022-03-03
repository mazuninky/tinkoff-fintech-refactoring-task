package ru.tinkoff.fintech.refactoring

data class Ingredient(
    val name: String,
    val price: Double
)

data class Pizza(
    val name: String,
    val requiredIngredients: List<Pair<Ingredient, Int>>
)
