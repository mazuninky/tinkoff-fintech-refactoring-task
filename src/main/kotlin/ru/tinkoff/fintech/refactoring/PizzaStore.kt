package ru.tinkoff.fintech.refactoring

class PizzaStore {
    var lastOrderNumber = 0

    fun orderCoffee(name: String): Order {
        val coffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return Order(
            number = ++lastOrderNumber,
            product = coffee
        )
    }

    fun orderPizza(name: String): Order {
        val pizza = Pizza.getPizzaByName(name)
            ?: error("Неизвестный вид пиццы!")

        return Order(
            number = ++lastOrderNumber,
            product = pizza
        )
    }
}