package ru.tinkoff.fintech.refactoring

class CoffeeStore {
    private val coffeeStore = listOf(Espresso(), Cappuccino())

    fun getCoffeeByName(name: String): Coffee? {
        return coffeeStore.find { it.name == name }
    }
}

interface Coffee : Product {

    val acidityInStars : Int
    val bitternessInStars : Int
    val bouquetInStars : Int
    fun calculateCoffeeBrewTimeInMinutes(): Int

}

class Espresso: Coffee {
    override val name: String = "эспрессо"
    override var price: Double = 5.0
    override val acidityInStars: Int
        get() = 4
    override val bitternessInStars: Int
        get() = 3
    override val bouquetInStars: Int
        get() = 4

    override fun calculateCoffeeBrewTimeInMinutes(): Int {
        return 5
    }
}

class Cappuccino: Coffee{
    override val acidityInStars: Int
        get() = 3
    override val bitternessInStars: Int
        get() = 2
    override val bouquetInStars: Int
        get() = 4

    override fun calculateCoffeeBrewTimeInMinutes(): Int {
        return 6
    }
    override val name: String = "капучино"
    override var price: Double = 3.48
}