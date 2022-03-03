package ru.tinkoff.fintech.refactoring.products

class Ingredient(
    override val name: String,
) : Product(name, true) {
    override fun toString(): String {
        return name
    }
}