package ru.tinkoff.fintech.refactoring.menu


interface CoffeeBrewer {
    fun calculateCoffeeBrewTimeInMinutes(): Int
}

interface CoffeeDAO {
    fun getCoffeeByName(name: String): Coffee?
}

class CoffeeDAOImpl : CoffeeDAO {

    private val coffeeStore = listOf(Espresso(), Cappuccino())

    override fun getCoffeeByName(name: String): Coffee? {
        return coffeeStore.find { it.name == name }
    }

}

abstract class Coffee(
    val name: String,
    val price: Double,
) : CoffeeBrewer


class Espresso : Coffee("эспрессо", 5.0) {
    override fun calculateCoffeeBrewTimeInMinutes() = 5
}

class Cappuccino : Coffee("капучино", 3.48) {
    override fun calculateCoffeeBrewTimeInMinutes() = 6
}