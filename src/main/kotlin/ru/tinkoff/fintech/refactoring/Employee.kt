package ru.tinkoff.fintech.refactoring

interface Employee {

    val title: String

}

class Barista : Employee {

    override val title: String = "[Бариста]"

    fun makeCoffee(orderId: Int, coffee: Coffee) {

        val roundedPrice = "%.2f".format(coffee.price)

        println("$title Готовлю напиток: ${coffee.coffeeName}")
        println("$title Время приготовления: ${coffee.time} минут")
        println("$title Стоимость напитка: $roundedPrice$")
        println("$title Заказ $orderId готов\n")

    }

}

class Cleaner : Employee {
    override val title: String = "[Уборщик]"

    fun cleanFloor() {
        println("$title Ну что опять!?")
        println("$title ...ворчание...")
        println("$title Уборка закончена!\n")
    }

}

class PizzaMaker : Employee {

    override val title: String = "[Пицца мейкер]"

    fun makePizza(orderId: Int, pizza: Pizza,ingredientsPrice: Map<String, Double>) {

        var pizzaPrice = 0.0
        var ingredientCounterAndTime = 0
        println("$title Делаю пиццу: ${pizza.pizzaName}")
        println("$title Из ингредиентов:")
        pizza.ingredients.forEach { (ingredient, amount) ->
            val price = ingredientsPrice[ingredient] ?: error("Неизвестный ингредиент")
            println("$title - $ingredient: в количестве $amount за $price$")
            pizzaPrice += price * amount
            ingredientCounterAndTime += amount
        }
        val roundedPrice = "%.2f".format(pizzaPrice)
        println("$title время приготовления $ingredientCounterAndTime минут")
        println("$title в сумме за все $roundedPrice$")
        println("$title заказ $orderId готов\n")

    }
}





