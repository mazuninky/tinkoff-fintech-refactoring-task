package ru.tinkoff.fintech.refactoring.employee.actions

import ru.tinkoff.fintech.refactoring.Coffee
import ru.tinkoff.fintech.refactoring.orders.CoffeeOrder

interface BaristaAction {
    fun makeCoffee(order: CoffeeOrder)
}