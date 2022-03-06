package ru.tinkoff.fintech.refactoring

abstract class Order {
    abstract var number: Int
}

data class CoffeeOrder(val coffee: Coffee, override var number: Int) : Order()
data class PizzaOrder(val pizza: Pizza, private val price: Double, override var number: Int) : Order()

class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = Coffee.getCoffeeByName(name)

        return CoffeeOrder(
            number = ++orderNumber,
            coffee = coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza.getPizzaName(name) ?: error("Неизвестный вид пиццы!")
        val ingredients = getIngredient(pizza)
        var pizzaPrice = 0.0
        ingredients.forEach { ingredient ->
            val ingredientName = ingredient.first
            val ingredientCount = ingredient.second
            val price = getPriceForIngredient(ingredientName)

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
            pizzaMaker.make(pizzaOrder)
        }

        if (coffeeOrder != null) {
            barista.make(coffeeOrder)
        }
    }
}

