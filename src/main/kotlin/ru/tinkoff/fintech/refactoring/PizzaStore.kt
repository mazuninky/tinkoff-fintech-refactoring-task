package ru.tinkoff.fintech.homework.task1


data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
    val price: Double
)

data class CoffeeOrder(
    val number: Int,
    val coffee: Coffee,
)

class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker: PizzaMaker = PizzaMaker()
    private val barista: Barista = Barista()

    fun orderCoffee(name: String) {
        val coffee = isCoffeeAvailable(name) ?: error("Неизвестный вид кофе!")
        val coffeeOrder: CoffeeOrder = CoffeeOrder(++orderNumber, coffee)
        barista.makeCoffee(coffeeOrder)
    }

    fun orderPizza(name: String) {
        val pizza = isPizzaAvailable(name) ?: error("Такой пиццы нет!")
        val price = calculatePrice(pizza)
        val pizzaOrder: PizzaOrder = PizzaOrder(++orderNumber, pizza, price)
        pizzaMaker.makePizza(pizzaOrder)
    }

}