package ru.tinkoff.fintech.refactoring

abstract class Order(open val number: Int) {
}

data class PizzaOrder(
    override val number: Int,
    val pizza: Pizza,
    val price: Double,
) : Order(number)

data class CoffeeOrder(
    override val number: Int,
    val coffee: Coffee,
) : Order(number)

class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker: Cook = PizzaMaker()
    private val barista: CoffeeMaker = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val newCoffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            coffee = newCoffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza(name)
        val ingredients = getIngredient(pizza)
        var pizzaPrice = 0.0
        ingredients.forEach { ingredient ->
            val price = ingredient.first.price
            val ingredientCount = ingredient.second

            pizzaPrice += price * ingredientCount
        }

        return PizzaOrder(
            number = ++orderNumber,
            pizza = pizza,
            price = pizzaPrice
        )
    }

    fun executeOrder(order: Order) {
        when (order) {
            is PizzaOrder -> pizzaMaker.makePizza(order.number, order.pizza, getIngredient(order.pizza))
            is CoffeeOrder -> barista.makeCoffee(order.number, order.coffee)
        }
    }
}