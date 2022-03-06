package ru.tinkoff.fintech.refactoring

enum class Coffee(val productName: String, val price: Double, val brewTimeInMinutes: Int) {
    ESPRESSO("эспрессо", 5.0, 5),
    CAPPUCINO("капучино", 3.48, 6);

    companion object {
        fun getCoffeeByName(name: String): Coffee = values().find { it.productName == name.lowercase() }
            ?: error("Неизвестный вид кофе!")
    }
}
