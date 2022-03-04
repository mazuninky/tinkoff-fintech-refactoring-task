package ru.tinkoff.fintech.refactoring.employee.actions

import ru.tinkoff.fintech.refactoring.orders.CoffeeOrder

interface BaristaInterface {
    fun makeCoffee(order: CoffeeOrder): String
}
