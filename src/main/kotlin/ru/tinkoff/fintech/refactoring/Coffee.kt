package ru.tinkoff.fintech.refactoring

enum class Coffee(val value: String, val price: Double, val time: Int) {
    ESPRESSO("эспрессо", 5.0, 5),
    CAPPUCINO("капучино", 3.48, 6);

    companion object {
        fun findCoffee(name: String): Coffee? {
            val lowercaseName = name.lowercase()
            return Coffee.values().find { it.value == lowercaseName }
        }
    }
}