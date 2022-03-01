package ru.tinkoff.fintech.refactoring

interface Employee {
    val typeOfEmployee : String
}

class Barista : Employee {
    override val typeOfEmployee = "[Бариста]"

    fun makeCoffee(orderId: Int, coffee: Coffee) {
        println("$typeOfEmployee Готовлю напиток: ${coffee.name}")
        println("$typeOfEmployee Время приготовления: ${coffee.calculateCoffeeBrewTimeInMinutes()} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("$typeOfEmployee Стоимость напитка: $roundedPrice")

        println("$typeOfEmployee заказ $orderId готов")
    }
}

class PizzaMaker : Employee {

    override val typeOfEmployee = "[Пицца мейкер]"

    fun makePizza(orderId: Int, pizza: Pizza) {
        println("$typeOfEmployee Делаю пиццу: ${pizza.name}")
        println("$typeOfEmployee Из ингридиетов:")
        var ingredientCounter = 0
        pizza.getIngredient().forEach { ingredient ->

            val price = PizzaIngredients.getIngredients(ingredient.name)

            println("$typeOfEmployee - ${ingredient.name}: в количестве ${ingredient.amount} за $price$")
            pizza.price += price * ingredient.amount
            ingredientCounter += ingredient.amount
        }

        println("$typeOfEmployee время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizza.price)
        println("$typeOfEmployee в сумме за все $roundedPrice$")

        println("$typeOfEmployee заказ $orderId готов")
    }
}
