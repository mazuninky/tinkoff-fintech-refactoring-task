package ru.tinkoff.fintech.refactoring

  class Coffee(
    val name: String,
    val price: Double,
    val brewTime: Int
) {

    companion object {
        private val coffeeList = listOf(Coffee("эспрессо", 5.0, 5),
            Coffee("капучино", 3.48,6))

        fun getCoffeeByName(name: String): Coffee {
            return coffeeList.find { it.name == name } ?: error("В меню нет такого кофе")
        }
    }
}

