package ru.tinkoff.fintech.refactoring.employee

import ru.tinkoff.fintech.refactoring.employee.actions.BaristaAction
import ru.tinkoff.fintech.refactoring.orders.CoffeeOrder

class Barista : BaristaAction {
    override fun makeCoffee(order: CoffeeOrder) {
        println("[Бариста] Готовлю напиток: ${order.coffee.name}")
        println("[Бариста] Время приготовления: ${order.coffee.BrewTimeInMinutes} минут")
        val roundedPrice = "%.2f".format(order.coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice$")

        println("[Бариста] заказ ${order.id} готов")
    }
}