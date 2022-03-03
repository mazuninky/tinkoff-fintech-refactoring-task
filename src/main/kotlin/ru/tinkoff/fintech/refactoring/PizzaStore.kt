package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.products.*

interface Order {
    val number: Int
    val product: Product
}

data class PizzaOrder(
    override val number: Int,
    override val product: Pizza
) : Order

data class CoffeeOrder(
    override val number: Int,
    override val product: Coffee,
) : Order

class PizzaStore {
    private var orderNumber = 0

    private val pizzaMaker = PizzaMakerImpl()
    private val barista = BaristaImpl()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = CoffeeService.getByName(name) ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            product = coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = PizzaService.getByName(name) ?: error("Неизвестный вид пиццы!")

        return PizzaOrder(
            number = ++orderNumber,
            product = pizza
        )
    }

    fun executeOrder(vararg orders: Order) {
        orders.forEach {
            when (it) {
                is CoffeeOrder -> barista.makeCoffee(it)
                is PizzaOrder -> pizzaMaker.makePizza(it)
                else -> error("Неизвестный вид заказа!")
            }
        }
    }
}