package ru.tinkoff.fintech.refactoring.assortment

abstract class Coffee(
    val name: String,
    val price: Double,
    val BrewTimeInMinutes: Int
)

class Espresso : Coffee("эспрессо", 5.0, 5)
class Cappuccino : Coffee("капучино", 3.48, 6)
