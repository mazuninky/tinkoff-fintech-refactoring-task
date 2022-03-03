package ru.tinkoff.fintech.refactoring

data class Coffee(
    val name: String,
    val price: Double,
    val brewTime: Int
) {
    companion object {
        private val coffeeStore = listOf(Coffee("эспрессо", 5.0, 5),
            Coffee("капучино", 3.48, 6))

        fun coffeeByName(name: String): Coffee {
            return coffeeStore.find { it.name == name } ?: error("В меню нет такого кофе")
        }
    }
}


