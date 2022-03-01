package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val id: Int,
    val pizza: Pizza,
)

data class CoffeeOrder(
    val id: Int,
    val coffee: Coffee,
)

class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker: PizzaMaker = PizzaMaker()
    private val barista: Barista = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = CoffeeStore.getCoffeeByName(name) ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(++orderNumber, coffee)
    }

    fun orderPizza(name: String): PizzaOrder? {
        val pizza = PizzaStore.getPizzaByName(name) ?: error("Неизвестный вид пиццы")

        return PizzaOrder(++orderNumber, pizza)
    }

    fun executeOrder(pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null) {
        if (pizzaOrder != null) {
            pizzaMaker.makePizza(pizzaOrder)
        }

        if (coffeeOrder != null) {
            barista.makeCoffee(coffeeOrder)
        }
    }

    companion object {
        private val store = listOf(Carbonara(), Marinara(), Sardinia(), Valtellina(), Peasant())

        fun getPizzaByName(name: String): Pizza? {
            return store.find { it.name == name }
        }
    }

}