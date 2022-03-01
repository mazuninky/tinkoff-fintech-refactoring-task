package ru.tinkoff.fintech.refactoring

abstract class Coffee(
    val name: String,
    val price: Double,
    val time: Int
)

class Espresso : Coffee("эспрессо", 5.0, 5)
class Cappuccino : Coffee("капучино", 3.48, 6)

val coffeeType = setOf(Espresso(), Cappuccino())

fun isCoffeeAvailable(name: String): Coffee? {
    return coffeeType.find { it.name == name }
}