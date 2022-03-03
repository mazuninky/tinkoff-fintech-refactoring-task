package ru.tinkoff.fintech.refactoring.employee.actions

import ru.tinkoff.fintech.refactoring.Coffee

interface BaristaAction {
    fun makeCoffee(orderId: Int, coffee: Coffee)
}