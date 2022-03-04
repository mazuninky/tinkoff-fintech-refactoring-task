package ru.tinkoff.fintech.refactoring

class Barista {
    fun makeCoffee(order: Order) {
        val coffee = coffeeMenu[order.name] ?: error("Невозможно приготовить \"${order.name}\"")
        val price = coffee.second

        println("[Бариста] Готовлю напиток: ${order.name}")
        println("[Бариста] Время приготовления: ${coffee.first} минут")
        val roundedPrice = "%.2f".format(price)
        println("[Бариста] Стоимость напитка: $roundedPrice")
    }
}

private val coffeeMenu = mapOf(
    "эспрессо" to Pair(5, 5.0),
    "капучино" to Pair(6, 3.48),
)