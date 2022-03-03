package ru.tinkoff.fintech.refactoring

abstract class Coffee(
    val name: String,
    val price: Double,
    val time: Int
) {

    companion object {
        private val coffeeStore = listOf(Espresso(), Cappuccino())

        fun getCoffeeByName(name: String): Coffee? {
            return coffeeStore.find { it.name == name }
        }
    }
}

class Espresso: Coffee("эспрессо", 5.0, 5)
class Cappuccino: Coffee("капучино", 3.48, 6)

fun calculateCoffeeBrewTimeInMinutes(
    coffee: Coffee
): Int {
    return coffee.time
}