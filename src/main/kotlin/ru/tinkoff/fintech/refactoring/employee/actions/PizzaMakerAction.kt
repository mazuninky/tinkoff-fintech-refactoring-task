package ru.tinkoff.fintech.refactoring.employee.actions

import ru.tinkoff.fintech.refactoring.Pizza

interface PizzaMakerAction {
    fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<String, Int>>)
}