package ru.tinkoff.fintech.refactoring.employee

import ru.tinkoff.fintech.refactoring.employee.actions.PizzaMakerInterface
import ru.tinkoff.fintech.refactoring.orders.PizzaOrder

class PizzaMaker : PizzaMakerInterface {
    override fun makePizza(order: PizzaOrder): String {
        var ingredientCounter = 0
        val roundedPrice = "%.2f".format(order.pizza.price)
        var string = ""

        string += "[Пицца мейкер] Делаю пиццу: ${order.pizza.name}\n"
        string += "[Пицца мейкер] Из ингридиетов:\n"

        order.pizza.ingredients.forEach {
            string += "[Пицца мейкер] - ${it.name}: в количестве ${it.count} за ${it.price}$\n"
            ingredientCounter += it.count
        }

        string += "[Пицца мейкер] время приготовления $ingredientCounter минут\n"
        string += "[Пицца мейкер] в сумме за все $roundedPrice$\n"
        string += "[Пицца мейкер] заказ ${order.id} готов\n"

        return string
    }
}
