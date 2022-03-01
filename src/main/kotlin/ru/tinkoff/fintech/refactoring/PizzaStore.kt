package ru.tinkoff.fintech.refactoring

abstract class Order(open val number: Int, open val product: Product)

data class PizzaOrder(override val number: Int, override val product: Product) : Order(number, product)

data class CoffeeOrder(override val number: Int, override val product: Product) : Order(number, product)

class PizzaStore {
    private var orderNumber = 0

    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()

    fun orderCoffee(name: String): Order {
        val coffee = CoffeeFactory().getCoffeeByName(name);

        return CoffeeOrder(
            number = ++orderNumber,
            product = coffee
        )
    }

    fun orderPizza(name: String): Order {
        val pizza = PizzaFactory().getPizzaByName(name)

        return PizzaOrder(
            number = ++orderNumber,
            product = pizza
        )
    }

    fun executeOrders(vararg orders: Order) {
        orders.asList().filterIsInstance<PizzaOrder>().forEach { pizzaMaker.makePizza(it) }
        orders.asList().filterIsInstance<CoffeeOrder>().forEach { barista.makeCoffee(it) }
    }
}
