package ru.tinkoff.fintech.refactoring

interface Cook {
    fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<Ingredient, Int>>)
}
interface CoffeeMaker
{
    fun makeCoffee(orderId: Int, coffee: Coffee)
}
interface Cleaner
{
    fun cleanFloor()
}

class Barista : CoffeeMaker {
    override fun makeCoffee(orderId: Int, coffee: Coffee) {
        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${calculateCoffeeBrewTimeInMinutes(coffee)} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ $orderId готов")
    }
}

class PizzaMaker : Cook {
    override fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<Ingredient, Int>>) {
        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        var pizzaPrice = 0.0
        var ingredientCounter = 0
        ingredients.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second

            val price = ingredientName.price

            println("[Пицца мейкер] - ${ingredientName.name}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizzaPrice)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ $orderId готов")
    }
}
