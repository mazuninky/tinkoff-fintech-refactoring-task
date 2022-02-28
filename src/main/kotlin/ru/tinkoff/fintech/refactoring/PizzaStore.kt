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
    private val pizzaDao: PizzaDao = PizzaDao()
    private val coffeeDao = CoffeeDao()
    private val pizzaMaker = PizzaMakerImpl()
    private val barista = BaristaImpl()
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

    fun executeOrder(pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null) {
        if (pizzaOrder != null) {
            pizzaMaker.makePizza(pizzaOrder)
        }

        if (coffeeOrder != null) {
            barista.makeCoffee(coffeeOrder)
        }
    }
}