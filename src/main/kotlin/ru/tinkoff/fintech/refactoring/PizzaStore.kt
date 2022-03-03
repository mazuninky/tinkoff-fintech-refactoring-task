package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.employee.Barista
import ru.tinkoff.fintech.refactoring.employee.PizzaMaker
import ru.tinkoff.fintech.refactoring.employee.actions.BaristaAction
import ru.tinkoff.fintech.refactoring.employee.actions.PizzaMakerAction

data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
    val price: Double
)

data class CoffeeOrder(
    val number: Int,
    val pizza: Coffee,
)

class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker: PizzaMakerAction = PizzaMaker()
    private val barista: BaristaAction = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            pizza = coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza(name)
        val ingredients = getIngredient(pizza)
        var pizzaPrice = 0.0
        ingredients.forEach { ingredient ->
            val ingredientName = ingredient.first
            val ingredientCount = ingredient.second

            val price = when (ingredientName) {
                "яйца" -> 3.48
                "бекон" -> 6.48
                "тесто" -> 1.00
                "томат" -> 1.53
                "оливки" -> 1.53
                "сыр" -> 0.98
                "пармезан" -> 3.98
                "грибы" -> 3.34
                "спаржа" -> 3.34
                "мясное ассорти" -> 9.38
                "вяленая говядина" -> 12.24
                else -> error("Неизвестный ингредиент")
            }

            pizzaPrice += price * ingredientCount
        }

        return PizzaOrder(
            number = ++orderNumber,
            pizza = pizza,
            price = pizzaPrice
        )
    }

    fun executeOrder(pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null) {
        if (pizzaOrder != null) {
            pizzaMaker.makePizza(pizzaOrder.number, pizzaOrder.pizza, getIngredient(pizzaOrder.pizza))
        }

        if (coffeeOrder != null) {
            barista.makeCoffee(coffeeOrder.number, coffeeOrder.pizza)
        }
    }
}