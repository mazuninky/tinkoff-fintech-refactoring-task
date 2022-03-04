package ru.tinkoff.fintech.refactoring.stores

import ru.tinkoff.fintech.refactoring.assortment.*
import ru.tinkoff.fintech.refactoring.employee.Barista
import ru.tinkoff.fintech.refactoring.employee.PizzaMaker
import ru.tinkoff.fintech.refactoring.orders.CoffeeOrder
import ru.tinkoff.fintech.refactoring.orders.Order
import ru.tinkoff.fintech.refactoring.orders.PizzaOrder


class Store {
    private var orderNumber = 0
    private val pizzaMaker: PizzaMaker = PizzaMaker()
    private val barista: Barista = Barista()
    private val coffeeStore: CoffeeStore = CoffeeStore()
    private val pizzaStore: PizzaStore = PizzaStore()
    private val orderList: ArrayList<Order> = arrayListOf()


    fun orderCoffee(name: String) {
        val coffee = coffeeStore.getCoffeeByName(name) ?: error("Неизвестный вид кофе!")

        orderList.add(
            CoffeeOrder(
                id = ++orderNumber,
                coffee = coffee
            )
        )
    }

    fun orderPizza(name: String) {
        val pizza = pizzaStore.getPizzaByName(name) ?: error("Неизвестный тип пиццы")

        orderList.add(
            PizzaOrder(
                id = ++orderNumber,
                pizza = pizza
            )
        )
    }

    fun execute() {
        orderList.forEach { i ->
            if (i is PizzaOrder)
                println(pizzaMaker.makePizza(i))
            if (i is CoffeeOrder)
                println(barista.makeCoffee(i))
        }
    }
}
