package ru.tinkoff.fintech.refactoring

interface Employee

interface Barista : Employee {
    fun makeCoffee(coffeeOrder: CoffeeOrder)
}

interface PizzaMaker : Employee {
    fun makePizza(pizzaOrder: PizzaOrder)
}

interface Cleaner : Employee {
    fun cleanFloor()
}

class BaristaImpl : Barista {
    override fun makeCoffee(coffeeOrder: CoffeeOrder) {
        val coffee = coffeeOrder.product

        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${coffee.brewTime} минут")

        val roundedPrice = "%.2f".format(coffee.price)

        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ ${coffeeOrder.number} готов")
    }
}

class PizzaMakerImpl : PizzaMaker {
    override fun makePizza(pizzaOrder: PizzaOrder) {
        val pizza = pizzaOrder.product

        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")

        var ingredientCounter = 0

        pizza.ingredientToNumber.forEach {
            val ingredient = it.key
            val ingredientCount = it.value

            println("[Пицца мейкер] - ${ingredient.name}: в количестве $ingredientCount за ${ingredient.price}$")
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")

        val roundedPrice = "%.2f".format(pizza.price)

        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${pizzaOrder.number} готов")
    }
}
