package ru.tinkoff.fintech.refactoring

abstract class Employee(val position: String)

class Barista : Employee("Бариста") {
    fun makeCoffee(coffeeOrder: CoffeeOrder) {
        val coffee = coffeeOrder.product as Coffee
        println("[$position] Готовлю напиток: ${coffee.name}")
        println("[$position] Время приготовления: ${coffee.brewTime} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[$position] Стоимость напитка: $roundedPrice")
        println("[$position] заказ ${coffeeOrder.number} готов")
    }
}

class PizzaMaker : Employee("Пицца мейкер") {
    fun makePizza(pizzaOrder: PizzaOrder) {
        val pizza = pizzaOrder.product as Pizza
        println("[$position] Делаю пиццу: ${pizza.name}")
        println("[$position] Из ингридиетов:")
        pizza.ingredients
            .forEach { (ingredient, quantity) ->
                println("[Пицца мейкер] - ${ingredient.name}: в количестве $quantity за ${ingredient.price}$")
            }
        val ingredientCounter = pizza.ingredients.values.sum()
        println("[$position] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizza.price)
        println("[$position] в сумме за все $roundedPrice$")
        println("[$position] заказ ${pizzaOrder.number} готов")
    }
}

