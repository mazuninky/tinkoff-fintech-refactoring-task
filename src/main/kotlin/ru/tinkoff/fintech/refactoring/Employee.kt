package ru.tinkoff.fintech.refactoring

interface Employee {
    fun doWork(coffeeOrder: CoffeeOrder)
    fun doWork(pizzaOrder: PizzaOrder)
}

class Barista(): Employee {
    override fun doWork(coffeeOrder: CoffeeOrder) {
        makeCoffee(coffeeOrder)
    }
    fun makeCoffee(coffeeOrder: CoffeeOrder) {
        println("[Бариста] Готовлю напиток: ${coffeeOrder.coffee.value}")
        println("[Бариста] Время приготовления: ${coffeeOrder.coffee.time} минут")
        val roundedPrice = "%.2f".format(coffeeOrder.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ ${coffeeOrder.number} готов")
    }

    override fun doWork(pizzaOrder: PizzaOrder) {
        println("[Бариста] Я не готовлю пиццу")
    }
}

class PizzaMaker: Employee {
    override fun doWork(pizzaOrder: PizzaOrder) {
        makePizza(pizzaOrder)
    }
    fun makePizza(pizzaOrder: PizzaOrder) {
        println("[Пицца мейкер] Делаю пиццу: ${pizzaOrder.pizza.value}")
        println("[Пицца мейкер] Из ингридиетов:")
        var ingredientCounter = 0
        pizzaOrder.pizza.ingredients.forEach { (ingredient, ingredientCount) ->
            println("[Пицца мейкер] - ${ingredient.value}: в количестве $ingredientCount за ${ingredient.price}$")
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizzaOrder.price)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${pizzaOrder.number} готов")
    }

    override fun doWork(coffeeOrder: CoffeeOrder) {
        println("[Пицца мейкер] я не готовлю кофе")
    }
}

