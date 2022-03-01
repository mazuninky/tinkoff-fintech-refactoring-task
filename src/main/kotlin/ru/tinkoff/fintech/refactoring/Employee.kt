package ru.tinkoff.fintech.refactoring

interface FloorCleanerInterface {
    fun cleanFloor()
}

interface BaristaInterface {
    fun makeCoffee(order: CoffeeOrder)
}

interface PizzaMakerInterface {
    fun makePizza(order: PizzaOrder)
}


abstract class Employee()


class Barista : Employee(), BaristaInterface {
    override fun makeCoffee(order: CoffeeOrder) {
        println("[Бариста] Готовлю напиток: ${order.coffee.name}")
        println("[Бариста] Время приготовления: ${order.coffee.brewTimeInMinutes} минут")

        val roundedPrice = "%.2f".format(order.coffee.price)

        println("[Бариста] Стоимость напитка: $roundedPrice")
        println("[Бариста] заказ ${order.id} готов")
    }
}


class PizzaMaker : Employee(), PizzaMakerInterface {
    override fun makePizza(order: PizzaOrder) {
        println("[Пицца мейкер] Делаю пиццу: ${order.pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")

        var ingredientCounter = 0

        order.pizza.ingredients.forEach { ingredient ->
            println("[Пицца мейкер] - ${ingredient.name}: в количестве ${ingredient.count} за ${ingredient.price}$")

            ingredientCounter += ingredient.count
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")

        val roundedPrice = "%.2f".format(order.pizza.price)

        println("[Пицца мейкер] в сумме за все $roundedPrice$")
        println("[Пицца мейкер] заказ ${order.id} готов")
    }

}
