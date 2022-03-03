package ru.tinkoff.fintech.refactoring

class Coffee(
    val name: String,
    val price: Double,
    val brewTimeMinutes: Int
) {

    companion object {
        val coffeeStore = listOf(Coffee("эспрессо", 5.0, 5),
                                    Coffee("капучино", 3.48, 6))
    }
}
