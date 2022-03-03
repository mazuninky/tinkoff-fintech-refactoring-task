package ru.tinkoff.fintech.refactoring

interface Employee {
}

fun String.say(message: String) {
    println("[$this] $message")
}

class Barista : Employee {
    private val employeeName = "Бариста"

    fun makeCoffee(order: CoffeeOrder) {
        val (orderId, coffee) = order
        employeeName.say("Готовлю напиток: ${coffee.name}")
        employeeName.say("Время приготовления: ${coffee.brewingTimeInMinutes} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        employeeName.say("Стоимость напитка: $roundedPrice")
        employeeName.say("заказ $orderId готов")
    }
}

class PizzaMaker : Employee {
    private val employeeName = ("Пицца мейкер")
    fun makePizza(order: PizzaOrder) {
        val (orderId, pizza) = order
        val ingredients = pizza.requiredIngredients

        employeeName.say("Делаю пиццу: ${pizza.name}")
        employeeName.say("Из ингредиентов:")

        var pizzaPrice = 0.0
        var ingredientCounter = 0

        ingredients.forEach { ingredientInfo ->
            val (ingredient, count) = ingredientInfo
            pizzaPrice += ingredient.price * count

            employeeName.say("- ${ingredient.name}: в количестве $count за ${ingredient.price}$")
            pizzaPrice += ingredient.price * count
            ingredientCounter += count
        }

        employeeName.say("время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizzaPrice)
        employeeName.say("в сумме за все $roundedPrice$")

        employeeName.say("заказ $orderId готов")
    }
}
