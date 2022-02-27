package ru.tinkoff.fintech.refactoring

class PizzaStore {
    var orderNumber = 0

    fun executeOrderPizzaMaker(namePizza: String) = PizzaMaker(PizzaOrder(++orderNumber, Pizza(namePizza,
    ingredientsPrice = IngredientsPrice()))).workInfo()

    fun executeOrderBarista(nameCoffee: String) = Barista(CoffeeOrder(++orderNumber, Coffee(nameCoffee))).workInfo()
}