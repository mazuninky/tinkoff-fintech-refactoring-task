package ru.tinkoff.fintech.refactoring.stores

import ru.tinkoff.fintech.refactoring.*
import ru.tinkoff.fintech.refactoring.employee.Barista
import ru.tinkoff.fintech.refactoring.employee.PizzaMaker
import ru.tinkoff.fintech.refactoring.orders.CoffeeOrder
import ru.tinkoff.fintech.refactoring.orders.PizzaOrder


class PizzaStore {
    private var orderNumber =
        0
    private val pizzaMaker: PizzaMaker =
        PizzaMaker()
    private val barista: Barista =
        Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee =
            CoffeeStore.getCoffeeByName(name) ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            id = ++orderNumber,
            coffee = coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza =
            getPizzaByName(name) ?: error("Неизвестный тип пиццы")

        return PizzaOrder(
            id = ++orderNumber,
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

    companion object {
        private val pizzaStore =
            listOf(Carbonara(), Marinara(), Sardinia(), Valtellina(), Peasant())

        fun getPizzaByName(name: String): Pizza? {
            return pizzaStore.find { it.name == name }
        }
    }
}
