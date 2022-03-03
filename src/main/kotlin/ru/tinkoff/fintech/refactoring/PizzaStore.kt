package ru.tinkoff.fintech.refactoring

class PizzaStore {
    var lastOrderNumber = 0

    fun orderCoffee(name: String): Order {
        val coffee = Coffee.getByName(name)
            ?: error("Неизвестный вид кофе!")

        return Order(
            number = ++lastOrderNumber,
            product = coffee
        )
    }

    fun orderPizza(name: String): Order {
        val pizza = Pizza.getByName(name)
            ?: error("Неизвестный вид пиццы!")

        return Order(
            number = ++lastOrderNumber,
            product = pizza
        )
    }
}
data class Order(
    val number: Int,
    val product: Product,
){
    private val pizzaMaker: PizzaMaker = PizzaMaker()
    private val barista: Barista = Barista()
    fun executeOrder() {
        when(this.product){
            is Pizza -> pizzaMaker.makePizza(this.number, this.product)
            is Coffee -> barista.makeCoffee(this.number, this.product)
        }
    }
}

abstract class Product(
    val name: String,
    var price: Double
)