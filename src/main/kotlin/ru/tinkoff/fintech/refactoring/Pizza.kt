package ru.tinkoff.fintech.refactoring

data class Pizza(
    val name: String,
    val ingredients: List<Pair<Ingredient, Int>>,
    var price: Double = 0.0,
)

class Ingredient (
    val name: String,
    var price: Double = 0.0,
)
