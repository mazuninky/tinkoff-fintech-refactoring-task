package ru.tinkoff.fintech.refactoring

class Coffee private constructor(
    name: String,
    price: Double,
    cookingTime: Int
) : Product(name, price, cookingTime) {
    companion object {
        private val coffeeStore = listOf(
            Coffee("эспрессо", 5.0, 5),
            Coffee("капучино", 3.48, 6)
        )

        fun getByName(name: String): Coffee {
            return coffeeStore.find { it.name == name }
                ?: error("Неизвестный вид кофе: $name")
        }
    }
}