package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.BaristaContainer

class Barista : CafeWorker<BaristaContainer>("Бариста") {

    override fun start(container: BaristaContainer) = makeCoffee(container)

    private fun makeCoffee(container: BaristaContainer) {
        val coffee = container.coffee
        val orderId = container.orderId
        println("[Бариста] Готовлю напиток: ${coffee.description.name}")
        println("[Бариста] Время приготовления: ${coffee.description.brewTime.seconds / 60} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ $orderId готов")
    }
}