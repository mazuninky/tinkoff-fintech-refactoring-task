package ru.tinkoff.fintech.refactoring

sealed class Order(
    val number: Int,
    open val product: Product
)

class PizzaOrder(
    number: Int,
    override val product: Pizza
) : Order(number, product)

class CoffeeOrder(
    number: Int,
    override val product: Coffee
) : Order(number, product)

class PizzaStore {
    private var orderNumber = 0

    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()

    fun orderCoffee(coffeeName: String): CoffeeOrder {
        val coffee = Coffee.getByName(coffeeName)
        return CoffeeOrder(
            number = nextOrder(),
            product = coffee
        )
    }

    fun orderPizza(pizzaName: String): PizzaOrder {
        val pizza = Pizza.getByName(pizzaName)
        return PizzaOrder(
            number = nextOrder(),
            product = pizza,
        )
    }

    fun executeOrder(vararg orders: Order) {
        orders.forEach { order ->
            when (order) {
                is PizzaOrder -> pizzaMaker.makePizza(order)
                is CoffeeOrder -> barista.makeCoffee(order)
            }
        }
    }

    private fun nextOrder() = ++orderNumber
}