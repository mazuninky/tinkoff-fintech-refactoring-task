package ru.tinkoff.fintech.refactoring

abstract class Coffee(
    val name: String,
    val price: Double,
    val brewTimeInMinutes: Int
)

class Espresso : Coffee("эспрессо", 5.0, 5)
class Cappuccino : Coffee("капучино", 3.48, 6)

class CoffeeStore {
    companion object {
        private val store = listOf(Espresso(), Cappuccino())

        fun getCoffeeByName(name: String): Coffee? {
            return store.find { it.name == name }
        }
    }
}
