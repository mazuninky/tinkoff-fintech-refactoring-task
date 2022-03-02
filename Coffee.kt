package ru.tinkoff.fintech.refactoring

enum class Coffee(val value: String, val price: Double, val time: Int) {
    ESPRESSO("эспрессо", 5.0, 5),
    CAPPUCINO("капучино", 3.48, 6);

    companion object {
        fun isCoffeeAvailable(name: String): Coffee? {
            return Coffee.values().find { it.value == name }
        }
    }
}