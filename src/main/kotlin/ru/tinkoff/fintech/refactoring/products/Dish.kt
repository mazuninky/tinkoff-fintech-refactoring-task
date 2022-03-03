package ru.tinkoff.fintech.refactoring.products

class Dish(
    override val name: String,
    val recipe: Map<String, Int>,
) : Product(name, true) {

    override fun toString(): String {
        return "{ $name : $recipe }"
    }
}