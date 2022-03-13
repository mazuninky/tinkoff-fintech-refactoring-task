package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val pizza: Pizza,
    val price: Double,
    override val number: Int = 0
) : Order()

data class PizzaOrderInfo(
    val pizzaPrice: Double,
    val ingredientCounter: Int
)

class PizzaStore : Store() {
    private val pizzaMaker: PizzaMakerEmployee = PizzaMaker()

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza(name)
        val ingredients = getIngredient(pizza)

        return PizzaOrder(
            number = ++orderNumber,
            pizza = pizza,
            price = getPizzaOrderInfo(ingredients, "order").pizzaPrice
        )
    }

    fun executeOrder(pizzaOrder: PizzaOrder? = null) {
        if (pizzaOrder != null) {
            pizzaMaker.makePizza(pizzaOrder.number, pizzaOrder.pizza, getIngredient(pizzaOrder.pizza))
        }
    }

}