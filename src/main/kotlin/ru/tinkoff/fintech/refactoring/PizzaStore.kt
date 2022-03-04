package ru.tinkoff.fintech.refactoring

class PizzaStore {

    var orderNumber = 0

    private val ingredientsPrice = mapOf("яйца" to 3.48,
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

    fun executeOrderPizza(pizzaName: String) =
        PizzaMaker().makePizza(++orderNumber, Pizza.getPizzaByName(pizzaName), ingredientsPrice)


    fun executeOrderCoffee(coffeeName: String) =
        Barista().makeCoffee(++orderNumber, Coffee.getCoffeeByName(coffeeName))

    fun executeCleaning() = Cleaner().cleanFloor()
}