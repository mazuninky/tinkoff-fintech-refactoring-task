package ru.tinkoff.fintech.refactoring

data class CoffeeOrder(
    val coffee: Coffee,
    override val number: Int = 0
) : Order()

class CoffeeStore : Store() {
    private val barista: BaristaEmployee = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")
        return CoffeeOrder(
            number = ++orderNumber,
            coffee = coffee
        )
    }

    override fun executeOrder(order: Order?) {
        if (order != null && order is CoffeeOrder) {
            barista.makeCoffee(order.number, order.coffee)
        }
    }

}