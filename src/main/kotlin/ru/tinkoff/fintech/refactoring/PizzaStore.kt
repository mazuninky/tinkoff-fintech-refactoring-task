package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
)

data class CoffeeOrder(
    val number: Int,
    val coffee: Coffee,
)

class PizzaStore {
    var orderNumber = 0
    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()
    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = Coffee.getCoffeeByName(name)
        return CoffeeOrder(
            number = ++orderNumber,
            coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val ingredients = getIngredient(Pizza(name))
        return PizzaOrder(
            number = ++orderNumber,
            pizza = Pizza(name),
        )
    }

    fun executeOrder(pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null) {
        if (pizzaOrder != null) {
            pizzaMaker.makePizza(pizzaOrder.number, pizzaOrder.pizza, getIngredient(pizzaOrder.pizza))
        }

        if (coffeeOrder != null) {
            barista.makeCoffee(coffeeOrder.number, coffeeOrder.coffee)
        }
    }
}