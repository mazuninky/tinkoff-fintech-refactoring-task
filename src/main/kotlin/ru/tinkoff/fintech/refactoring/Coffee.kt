package ru.tinkoff.fintech.refactoring

abstract class Coffee(
    val name: String,
    val price: Double,
    private val brewTime: Int? = null
) {
    override fun toString() = name

    companion object {
        private val coffeeStore = listOf(Espresso(), Cappuccino())

        fun getByName(name: String): Coffee? {
            return coffeeStore.find { it.name == name }
        }

        fun calculateBrewTimeInMinutes(coffee: Coffee): Int {
            return coffee.brewTime ?: error("Неизвестный вид кофе")
        }
    }
}

class Espresso : Coffee("эспрессо", 5.0, 5)
class Cappuccino : Coffee("капучино", 3.48, 6)