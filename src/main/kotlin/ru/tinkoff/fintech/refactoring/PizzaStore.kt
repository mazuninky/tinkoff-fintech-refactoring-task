package ru.tinkoff.fintech.refactoring

class PizzaStore {

    var orderNumber = 0

    private var pizzaValueIngredients = mutableMapOf(
        "карбонара" to listOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2),
        "маринара" to listOf("томат" to 2, "оливки" to 3, "тесто" to 1),
        "сардиния" to listOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3),
        "вальтеллина" to listOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2),
        "крестьянская" to listOf("грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1))

    fun executeOrderPizzaMaker(namePizza: String) = PizzaMaker().makePizza(
        ++orderNumber, Pizza(namePizza.lowercase(),pizzaValueIngredients))

    fun executeOrderBarista(nameCoffee: String) = Barista().makeCoffee(
        ++orderNumber, Coffee.getCoffeeByName(nameCoffee.lowercase()))

    fun executeCleaning() = Cleaner().cleanFloor()
}