package ru.tinkoff.fintech.refactoring

interface Employee {

    val title: String

}

class Barista : Employee {

    override val title: String = "[Бариста]"

    fun makeCoffee(orderId: Int, coffee: Coffee) {

        val roundedPrice = "%.2f".format(coffee.price)

        val textWorkExecute = listOf(
            "$title Готовлю напиток: ${coffee.name}",
            "$title Время приготовления: ${coffee.time} минут",
            "$title Стоимость напитка: $roundedPrice$",
            "$title Заказ $orderId готов\n").joinToString("\n")

        println(textWorkExecute)
    }

}

class Cleaner : Employee {
    override val title: String = "[Уборщик]"

    private val textWorkExecute = listOf(
        "$title Ну что опять!?",
        "$title ...ворчание...",
        "$title Уборка закончена!\n").joinToString("\n")

    fun cleanFloor() = println(textWorkExecute)

}

class PizzaMaker : Employee {

    override val title: String = "[Пицца мейкер]"

    fun makePizza(orderId: Int, pizza: Pizza) {

        val roundedPrice = "%.2f".format(pizza.getPizzaTextPriceTime()[1])

        val textWorkExecute = listOf(
            "$title Делаю пиццу: ${pizza.name}",
            "$title Из ингридиетов:",
            pizza.getPizzaTextPriceTime()[0],
            "$title время приготовления ${pizza.getPizzaTextPriceTime()[2]} минут",
            "$title в сумме за все $roundedPrice$",
            "$title заказ $orderId готов\n").joinToString("\n")

        println(textWorkExecute)

    }
}





