package ru.tinkoff.fintech.refactoring.employee

import ru.tinkoff.fintech.refactoring.employee.actions.BaristaAction
import ru.tinkoff.fintech.refactoring.employee.actions.PizzaMakerAction
import ru.tinkoff.fintech.refactoring.orders.CoffeeOrder
import ru.tinkoff.fintech.refactoring.orders.PizzaOrder

class Barista : BaristaAction {
    override fun makeCoffee(order: CoffeeOrder) {
        println("[Бариста] Готовлю напиток: ${order.coffee.name}")
        println("[Бариста] Время приготовления: ${order.coffee.BrewTimeInMinutes} минут")
        val roundedPrice = "%.2f".format(order.coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice$")

        println("[Бариста] заказ ${order.id} готов")
    }
}

class PizzaMaker : PizzaMakerAction {
    override fun makePizza(order: PizzaOrder) {
        println("[Пицца мейкер] Делаю пиццу: ${order.pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        var ingredientCounter = 0

        order.pizza.ingredients.forEach {
            println("[Пицца мейкер] - ${it.name}: в количестве ${it.count} за ${it.price}$")
            ingredientCounter += it.count
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(order.pizza.price)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${order.id} готов")
    }
}
