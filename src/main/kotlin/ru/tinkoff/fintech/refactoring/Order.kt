package ru.tinkoff.fintech.refactoring

class Order(
    val coffeeOrderInfo: CoffeeOrderInfo?,
    val pizzaOrderInfo: PizzaOrderInfo?
)

class CoffeeOrderInfo {
    var coffeeName: String? = null
    var brewTimeInMinutes: Int? = null
    var coffeePrice: String? = null
    var orderId: Int? = null
}

class PizzaOrderInfo {
    var pizzaName: String? = null
    var pizzaPrice: String? = null
    var ingredients: List<Pair<String, Int>> = mutableListOf()
    var orderId: Int? = null
    var cookingTime: Int? = null
}
