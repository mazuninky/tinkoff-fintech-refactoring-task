package ru.tinkoff.fintech.refactoring.employee

import ru.tinkoff.fintech.refactoring.menu.Coffee

// не стал создавать такой интерфейс, потому что не было необходимости
// interface Employee
interface Barista {
    fun makeCoffee(orderId: Int, coffee: Coffee)
}

class BaristaImpl : Barista {

    override fun makeCoffee(orderId: Int, coffee: Coffee) {
        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${coffee.calculateCoffeeBrewTimeInMinutes()} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ $orderId готов")
    }
}