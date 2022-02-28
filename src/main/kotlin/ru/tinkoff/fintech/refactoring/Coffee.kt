package ru.tinkoff.fintech.refactoring

abstract class Coffee(
    val name: String,
    val price: Double,
    val brewTimeInMinutes: Int
)

class Espresso : Coffee(
    name = "эспрессо",
    price = 5.0,
    brewTimeInMinutes = 5
)

class Cappuccino : Coffee(
    name = "капучино",
    price = 3.48,
    brewTimeInMinutes = 6
)

class CoffeeDao {
    fun getCoffeeByName(name: String): Coffee? =
        coffeeStore.firstOrNull { it.name == name }

    companion object {
        private val coffeeStore = listOf(Espresso(), Cappuccino())
    }
}
