package ru.tinkoff.fintech.refactoring.employee.actions

import ru.tinkoff.fintech.refactoring.orders.PizzaOrder

interface PizzaMakerInterface {
    fun makePizza(order: PizzaOrder): String
}
