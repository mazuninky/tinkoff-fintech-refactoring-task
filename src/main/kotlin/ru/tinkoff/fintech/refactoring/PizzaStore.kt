package ru.tinkoff.fintech.refactoring

data class PizzaOrder(val number: Int, val pizza: Pizza, val price: Double)

data class CoffeeOrder(val number: Int, val coffee: Coffee)

class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(number = ++orderNumber, coffee = coffee)
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza.getPizzaByName(name)
            ?: error("Неизвестный вид пиццы!")
        val ingredients = pizza.getIngredient()
        var pizzaPrice = 0.0
        ingredients.forEach {
            val ingredientForPrice = Ingredient.getIngredientByName(it.first)
            val ingredientCount = it.second

            pizzaPrice += ingredientForPrice?.price!! * ingredientCount
        }

        return PizzaOrder(number = ++orderNumber, pizza = pizza, price = pizzaPrice)
    }

    fun executeOrder(pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null) {
        if (pizzaOrder != null) {
            pizzaMaker.makePizza(pizzaOrder.number, pizzaOrder.pizza, pizzaOrder.pizza.getIngredient())
        }

        if (coffeeOrder != null) {
            barista.makeCoffee(coffeeOrder.number, coffeeOrder.coffee)
        }
    }
}