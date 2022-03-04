package ru.tinkoff.fintech.refactoring

class Barista {
    fun makeCoffee(order: Order) {
        val coffee = coffeeMenu[order.name] ?: error("Невозможно приготовить \"${order.name}\"")
        val price = coffee.price

        println("[Бариста] Готовлю напиток: ${order.name}")
        println("[Бариста] Время приготовления: ${coffee.brewTime} минут")
        val roundedPrice = "%.2f".format(price)
        println("[Бариста] Стоимость напитка: $roundedPrice$")
    }
}


private val coffeeMenu = listOf(
    Coffee("эспрессо", 5, 5.0),
    Coffee("капучино", 6, 3.48),
).associateBy { it.name }

private data class Coffee(
    val name: String,
    val brewTime: Int,
    val price: Double,
)