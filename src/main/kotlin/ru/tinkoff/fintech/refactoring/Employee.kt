package ru.tinkoff.fintech.refactoring

interface Employee {
    fun work()

}
interface IBarista:Employee{
    fun makeCoffee(coffeeOrder: CoffeeOrder)
}

class Barista : IBarista {
    override fun work() {
        println("[Бариста] Прихожу на работу к 10 часам")
    }
    override fun makeCoffee(coffeeOrder: CoffeeOrder) {
        val coffee = coffeeOrder.coffee
        val orderId = coffeeOrder.number
        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${calculateCoffeeBrewTimeInMinutes(coffee)} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")
        println("[Бариста] заказ $orderId готов")
    }
}

interface ICleaner:Employee{
    fun cleanFloor()
}

class Cleaner: ICleaner{
    override fun work() {
        println("[Уборщик] Прихожу на работу к 6 часам")
    }
    override fun cleanFloor(){
        println("[Уборщик] Мою полы")
    }
}

interface IPizzaMaker:Employee{
    fun makePizza(pizzaOrder: PizzaOrder)
}

class PizzaMaker : IPizzaMaker {
    override fun work() {
        println("[Пицца мейкер] Прихожу на работу к 8 часам")
    }

    override fun makePizza(pizzaOrder: PizzaOrder) {
        val pizza = pizzaOrder.pizza
        val ingredients = getIngredient(pizza)
        val orderId = pizzaOrder.number
        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        var pizzaPrice = 0.0
        var ingredientCounter = 0
        ingredients.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second
            val price = ingredientsPrice(ingredientName)
            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizzaPrice)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ $orderId готов")
    }
}

