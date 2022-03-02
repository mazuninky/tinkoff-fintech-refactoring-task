package ru.tinkoff.fintech.refactoring

interface Coffee {
    val name: String
    val price: Double
    val brewTimeInMinutes: Int
}

class Espresso(
) : Coffee {
    override val name: String
        get() = "эспрессо"
    override val price: Double
        get() = 5.0
    override val brewTimeInMinutes: Int
        get() = 5
}

class Cappuccino(

) : Coffee {
    override val name: String
        get() = "капучино"
    override val price: Double
        get() = 3.48
    override val brewTimeInMinutes: Int
        get() = 6
}

class CoffeeDao(private val coffeeStore: List<Coffee>) {

    fun getCoffeeByName(name: String): Coffee? =
        coffeeStore.firstOrNull { it.name == name }
}
