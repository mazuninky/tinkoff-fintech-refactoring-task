package ru.tinkoff.fintech.refactoring

class Coffee(
    name: String,
    price: Double,
    val brewTimeInMinutes: Int ) : Product(name, price)
{
    companion object {
        private val coffeeList = listOf(
            Coffee("эспрессо", 5.0, 5),
            Coffee("капучино", 3.48, 6)
        )

        fun getByName(name: String): Coffee? {
            return coffeeList.find { it.name == name }
        }
    }
}

