package ru.tinkoff.fintech.refactoring

interface Employee {
    val name: String

    fun say(message: Any?) = println("[$name] $message")

    fun makePizza(order: PizzaOrder) {
        say("Я не умею готовить пиццу")
    }

    fun makeCoffee(order: CoffeeOrder) {
        say("Я не умею готовить кофе")
    }

    fun finish(orderId: Int, timeInMinutes: Int, price: Double) {
        say("Время приготовления: $timeInMinutes минут")
        val roundedPrice = "%.2f".format(price)
        say("Стоимость заказа: $roundedPrice")
        say("заказ $orderId готов")
    }

    fun cleanFloor() {
        say("Я не умею мыть полы")
    }
}

class Barista : Employee {
    override val name get() = "Бариста"

    override fun makeCoffee(order: CoffeeOrder) {
        val (orderId, coffee) = order
        say("Готовлю напиток: $coffee")

        finish(orderId, Coffee.calculateBrewTimeInMinutes(coffee), coffee.price)
    }
}

class PizzaMaker : Employee {
    override val name get() = "Пицца мейкер"

    override fun makePizza(order: PizzaOrder) {
        val (orderId, pizza, ingredients) = order

        say("Делаю пиццу: $pizza")
        say("Из ингредиентов:")
        ingredients.forEach {
            say("- ${it.name}: в количестве ${it.count} за ${it.price}$")
        }
        val ingredientCounter = ingredients.sumOf { it.count }
        val pizzaPrice = ingredients.sumOf { it.price * it.count }

        finish(orderId, ingredientCounter, pizzaPrice)
    }
}
