package ru.tinkoff.fintech.refactoring

interface Coffee : Product {

    companion object {
    private val coffeeStore = listOf(Espresso(), Cappuccino())

    fun getCoffeeByName(name: String): Coffee? {
        return coffeeStore.find { it.name == name }
    }
}
    fun calculateCoffeeBrewTimeInMinutes(): Int

}

class Espresso: Coffee {
    override val name: String = "эспрессо"
    override var price: Double = 5.0
    override fun calculateCoffeeBrewTimeInMinutes(): Int {
        return 5
    }
}

class Cappuccino: Coffee{
    override fun calculateCoffeeBrewTimeInMinutes(): Int {
        return 6
    }
    override val name: String = "капучино"
    override var price: Double = 3.48
}