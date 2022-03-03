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
        println("$title Из ингридиетов:")
        pizza.pizzaValueIngredients.forEach {
            val ingredientName = it.key
            val ingredientCount = it.value
            val price = ingredientsPrice[ingredientName] ?: error("Неизвестный ингредиент")
            println("$title - ${ingredientName}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounterAndTime += ingredientCount
        }
        val roundedPrice = "%.2f".format(pizzaPrice)
        println("$title время приготовления $ingredientCounterAndTime минут")
        println("$title в сумме за все $roundedPrice$")
        println("$title заказ $orderId готов\n")

    }
}





