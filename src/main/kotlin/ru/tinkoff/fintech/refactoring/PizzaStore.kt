package ru.tinkoff.fintech.refactoring

data class OrderPizza(
    val number: Int,
    val pizza: Pizza
)

data class OrderCoffee(
    val number: Int,
    val coffee: Coffee
)

class PizzaStore {
    private var orderNumber = 0

    private val pizzaMaker = Chef()
    private val barista = Barista()

    private val availableCoffee = listOf(Espresso(), Cappuccino())

    private val availablePizza = listOf(Carbonara(), Marinara(), Sardinia(), Valtellina(), Peasant())

    private fun getPizzaByName(name: String): Pizza? {
        return availablePizza.find { it.name == name }
    }

    private fun getCoffeeByName(name: String): Coffee? {
        return availableCoffee.find { it.name == name }
    }

    fun orderCoffee(name: String): OrderCoffee {
        val coffee = getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return OrderCoffee(
            number = ++orderNumber,
            coffee = coffee
        )
    }

    fun orderPizza(name: String): OrderPizza {
        val pizza = getPizzaByName(name)
            ?: error("Неизвестный вид пиццы!")

        return OrderPizza(
            number = ++orderNumber,
            pizza = pizza
        )
    }

    fun executeOrder(order: OrderCoffee) {
        barista.makeCoffee(order.number, order.coffee)
    }

    fun executeOrder(order: OrderPizza) {
        pizzaMaker.makePizza(order.number, order.pizza)
    }
}