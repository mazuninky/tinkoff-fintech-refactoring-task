package ru.tinkoff.fintech.refactoring

data class Coffee(override val name: String, override val price: Double, val brewTime: Int) : Product(name, price)

class CoffeeDAO {
    fun getCoffeeByName(name: String): Coffee {
        return when (name) {
            "эспрессо" -> Coffee(name, 5.0, 5)
            "капучино" -> Coffee(name, 3.48, 6)
            else -> error("Неизвестный вид кофе")
        }
    }
}
