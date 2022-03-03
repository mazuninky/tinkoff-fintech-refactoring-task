package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val orderID: Int,
    val pizza: Pizza,
    val price: Double
)

data class CoffeeOrder(
    val orderID: Int,
    val coffee: Coffee,
)


class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker: Employee = PizzaMaker()
    private val barista: Employee = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            orderID = ++orderNumber,
            coffee = coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza.getPizzaByName(name)
            ?: error("Неизвестный вид пиццы!")

        return PizzaOrder(
            orderID = ++orderNumber,
            pizza = pizza,
            price = pizza.price
        )
    }


    fun executeOrder(pizzaOrder: PizzaOrder? = null){
        if (pizzaOrder != null) {
            pizzaMaker.makePizza(pizzaOrder)
        }
    }

    fun executeOrder(coffeeOrder: CoffeeOrder? = null){
        if (coffeeOrder != null) {
            barista.makeCoffee(coffeeOrder)
        }
    }
}