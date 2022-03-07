package ru.tinkoff.fintech.refactoring

import java.util.*


interface Employee {
    val typeOfEmployee : String
    val workingTimeInHours : Int
    val basicSalaryPerHour : Double

    fun calculateSalary(): Double {
        val calendar = Calendar.getInstance()
        val maxDay: Int = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        return maxDay * workingTimeInHours * basicSalaryPerHour
    }
}

class Barista : Employee {
    override val typeOfEmployee = "[Бариста]"
    override val workingTimeInHours: Int
        get() = 8
    override val basicSalaryPerHour: Double = 500.50


    fun makeCoffee(orderId: Int, coffee: Coffee) {
        println("$typeOfEmployee Готовлю напиток: ${coffee.name}")
        println("$typeOfEmployee Время приготовления: ${coffee.calculateCoffeeBrewTimeInMinutes()} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("$typeOfEmployee Стоимость напитка: $roundedPrice")

        println("$typeOfEmployee кофе из заказа $orderId готов")
    }
}

class PizzaMaker : Employee {

    override val typeOfEmployee = "[Пицца мейкер]"
    override val basicSalaryPerHour: Double = 600.75
    override val workingTimeInHours: Int
        get() = 5

    fun makePizza(orderId: Int, pizza: Pizza) {
        println("$typeOfEmployee Делаю пиццу: ${pizza.name}")
        println("$typeOfEmployee Из ингридиетов:")
        var ingredientCounter = 0
        pizza.getIngredient().forEach { ingredient ->

            val price = PizzaIngredients.getIngredientPrice(ingredient.name)

            println("$typeOfEmployee - ${ingredient.name}: в количестве ${ingredient.amount} за $price$")
            pizza.price += price * ingredient.amount
            ingredientCounter += ingredient.amount
        }

        println("$typeOfEmployee время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizza.price)
        println("$typeOfEmployee в сумме за все $roundedPrice$")

        println("$typeOfEmployee пицца из заказа $orderId готова")
    }
}
