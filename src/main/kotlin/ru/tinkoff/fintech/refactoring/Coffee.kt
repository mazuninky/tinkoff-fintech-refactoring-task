package ru.tinkoff.fintech.refactoring


abstract class Coffee(
    val name: String,
    val price: Double,
) {

    abstract fun coffeeBrewTimeInMins(): Int

    companion object {
        private val coffeeStore = listOf(Espresso(), Cappuccino())

        fun getCoffeeByName(name: String): Coffee? {
            return coffeeStore.find { it.name == name }
        }
    }
}

class Espresso: Coffee("эспрессо", 5.0)
{
    override fun coffeeBrewTimeInMins(): Int {
        return 5
    }
}
class Cappuccino: Coffee("капучино", 3.48)
{
    override fun coffeeBrewTimeInMins(): Int {
        return 6
    }
}