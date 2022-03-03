package ru.tinkoff.fintech.refactoring

class Barista : Employee {
    override val empName = "Бариста"

    override fun makeCoffee(
        orderId: Int,
        coffee: Coffee
    ) {
        "Готовлю напиток: ${coffee.name}".showPhrase()
        "Время приготовления: ${coffee.brewTimeInMinutes} минут".showPhrase()
        val roundedPrice = "%.2f".format(coffee.price)
        "Стоимость напитка: $roundedPrice".showPhrase()
        "Заказ $orderId готов".showPhrase()
    }
}