package ru.tinkoff.fintech.refactoring.employee.actions

import ru.tinkoff.fintech.refactoring.orders.PizzaOrder

interface PizzaMakerAction {
    fun makePizza(order:PizzaOrder)
}