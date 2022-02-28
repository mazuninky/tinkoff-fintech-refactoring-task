package ru.tinkoff.fintech.refactoring

interface CoffeeBrewer {
    fun calculateCoffeeBrewTimeInMinutes(): Int
}

abstract class Coffee(val name: String, val price: Double) : CoffeeBrewer {

    companion object {
        private val coffeeStore = listOf(Espresso(), Cappuccino())

        fun getCoffeeByName(name: String): Coffee? {
            return coffeeStore.find { it.name == name }
        }
    }
}

class Espresso : Coffee("эспрессо", 5.0) {
    override fun calculateCoffeeBrewTimeInMinutes() = 5
}

class Cappuccino : Coffee("капучино", 3.48) {
    override fun calculateCoffeeBrewTimeInMinutes() = 6
}