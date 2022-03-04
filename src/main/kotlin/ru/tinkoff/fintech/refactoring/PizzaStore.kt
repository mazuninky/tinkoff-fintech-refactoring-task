package ru.tinkoff.fintech.refactoring

class PizzaStore {
    private val pizzaMaker = PizzaMaker()

    private val barista = Barista()

    private val cleaner = Cleaner()

    var orderNumber = 0

    private val ingredientsPrice = mapOf(
        "яйца" to 3.48,
        "бекон" to 6.48,
        "тесто" to 1.00,
        "томат" to 1.53,
        "оливки" to 1.53,
        "сыр" to 0.98,
        "пармезан" to 3.98,
        "грибы" to 3.34,
        "спаржа" to 3.34,
        "мясное ассорти" to 9.38,
        "вяленая говядина" to 12.24)

    fun executeOrderPizza(pizzaName: String) {
        val pizza = Pizza.getPizzaByName(pizzaName)

        return pizzaMaker.makePizza(++orderNumber, pizza, ingredientsPrice)
    }

    fun executeOrderCoffee(coffeeName: String) {
        val coffee = Coffee.getCoffeeByName(coffeeName)

        return barista.makeCoffee(++orderNumber, coffee)
    }

    fun executeCleaning() = cleaner.cleanFloor()
}