package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
    val price: Double
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
        val currentCoffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            coffee = currentCoffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza(name)
        val ingredients = getIngredient(pizza)
        var pizzaPrice = 0.0
        ingredients.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second
            val price = ingredientsPrice(ingredientName)
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
            pizzaMaker.makePizza(pizzaOrder)
        }

        if (coffeeOrder != null) {
            barista.makeCoffee(coffeeOrder)
        }
    }
}