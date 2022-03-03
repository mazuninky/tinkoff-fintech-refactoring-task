package ru.tinkoff.fintech.refactoring.products

abstract class Coffee(
    final override val name: String,
    final override val price: Double,
    val brewTime: Int
) : Product {
    init {
        check(price >= 0) { "non negative price expected, but found: $price" }
        check(brewTime > 0) { "positive brew rime expected, but found: $brewTime" }
    }
}

class Espresso : Coffee("эспрессо", 5.0, 5)
class Cappuccino : Coffee("капучино", 3.48, 6)