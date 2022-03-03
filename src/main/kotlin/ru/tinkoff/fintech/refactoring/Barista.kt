package ru.tinkoff.fintech.refactoring

class Barista : CoffeeMaker {
    override fun makeCoffee(orderId: Int, coffee: Coffee) {
        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${coffee.BrewTimeInMinutes} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ $orderId готов")
    }
}