package ru.tinkoff.fintech.refactoring.employee

import ru.tinkoff.fintech.refactoring.employee.actions.BaristaInterface
import ru.tinkoff.fintech.refactoring.orders.CoffeeOrder

class Barista : BaristaInterface {
    override fun makeCoffee(order: CoffeeOrder): String {
        val roundedPrice = "%.2f".format(order.coffee.price)
        var string = ""

        string += "[Бариста] Готовлю напиток: ${order.coffee.name}\n"
        string += "[Бариста] Время приготовления: ${order.coffee.BrewTimeInMinutes} минут\n"
        string += "[Бариста] Стоимость напитка: $roundedPrice$\n"
        string += "[Бариста] заказ ${order.id} готов\n"
        return string
    }
}
