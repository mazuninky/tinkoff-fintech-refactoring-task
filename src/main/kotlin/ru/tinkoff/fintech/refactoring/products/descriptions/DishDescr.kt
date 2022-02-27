package ru.tinkoff.fintech.refactoring.products.descriptions

class DishDescr(
    override val name: String,
    val recipe: Map<String, Int> = mapOf()
) : Description