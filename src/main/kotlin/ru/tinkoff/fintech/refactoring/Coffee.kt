package ru.tinkoff.fintech.refactoring

abstract class Coffee(
    val name: String,
    val price: Double,
) {
    companion object {
        private val coffeeStore = listOf(Espresso(), Cappuccino())

        fun getCoffeeByName(name: String): Coffee? {
            return coffeeStore.find { it.name == name }
        }
    }
}

class Espresso : Coffee("эспрессо", 5.0)
class Cappuccino : Coffee("капучино", 3.48)

fun calculateCoffeeBrewTimeInMinutes(
    coffee: Coffee
): Int {
    return when (coffee) {
        is Espresso -> 5
        is Cappuccino -> 6
        else -> error("Неизвестный вид кофе")
    }
}