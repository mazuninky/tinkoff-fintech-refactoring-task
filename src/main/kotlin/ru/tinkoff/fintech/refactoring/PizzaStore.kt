package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val orderId: Int,
    val pizza: Pizza
)

data class CoffeeOrder(
    val orderId: Int,
    val coffee: Coffee,
)

class PizzaStore {
    private val pizzaDao: PizzaDao = PizzaDao(
        listOf(Carbonara(), Marinara(), Sardinia(), Valtellina(), Krestyanskaya())
    )
    private val coffeeDao = CoffeeDao(
        listOf(Espresso(), Cappuccino())
    )
    private val pizzaMaker = SimplePizzaMaker()
    private val barista = SimpleBarista()
    var orderId = 0

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = coffeeDao.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")
        return CoffeeOrder(
            orderId = ++orderId,
            coffee = coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = pizzaDao.getPizzaByName(name)
            ?: error("Неизвестный вид пиццы!")
        return PizzaOrder(
            orderId = ++orderId,
            pizza = pizza
        )
    }

    fun executeOrder(pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null): Order {
        val pizzaOrderInfo = pizzaOrder?.let { pizzaMaker.makePizza(it) }
        val coffeeOrderInfo = coffeeOrder?.let { barista.makeCoffee(it) }
        return Order(coffeeOrderInfo, pizzaOrderInfo)
    }
}