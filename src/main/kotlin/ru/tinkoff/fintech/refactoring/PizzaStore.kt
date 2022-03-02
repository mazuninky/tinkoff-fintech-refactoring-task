package ru.tinkoff.fintech.refactoring

interface Order {
    val number: Int
}

data class PizzaOrder(
    override val number: Int,
    val pizza: Pizza,
    val ingredients: List<Ingredient>,
) : Order

data class CoffeeOrder(
    override val number: Int,
    val coffee: Coffee,
) : Order

class PizzaStore {
    private var orderNumber = 0

    private val pizzaMaker: Employee = PizzaMaker()
    private val barista: Employee = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = Coffee.getByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            coffee = coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza(name)
        val ingredients = getIngredient(pizza).map { Ingredient(it) }

        return PizzaOrder(
            number = ++orderNumber,
            pizza = pizza,
            ingredients = ingredients,
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