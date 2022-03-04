package ru.tinkoff.fintech.refactoring


enum class Coffee(val coffeeName: String, val price: Double, val time: Int) {
    ESPRESSO("эспрессо", 5.0, 5),
    CAPPUCCINO("капучино", 3.48, 6);

    companion object {
        fun getCoffeeByName(name: String): Coffee = values().find { it.coffeeName == name.lowercase() }
            ?: error("Неизвестный вид кофе!")

    }
}



