package ru.tinkoff.fintech.refactoring.employee

import ru.tinkoff.fintech.refactoring.employee.actions.PizzaMakerAction
import ru.tinkoff.fintech.refactoring.orders.PizzaOrder

class PizzaMaker : PizzaMakerAction {
    override fun makePizza(order: PizzaOrder) {
        var ingredientCounter =
            0
        val roundedPrice =
            "%.2f".format(order.pizza.price)

        println("[Пицца мейкер] Делаю пиццу: ${order.pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")

        order.pizza.ingredients.forEach {
            println("[Пицца мейкер] - ${it.name}: в количестве ${it.count} за ${it.price}$")
            ingredientCounter += it.count
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        println("[Пицца мейкер] в сумме за все $roundedPrice$")
        println("[Пицца мейкер] заказ ${order.id} готов")
    }
}
