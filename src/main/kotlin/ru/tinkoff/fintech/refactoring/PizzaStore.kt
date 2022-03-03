package ru.tinkoff.fintech.refactoring
interface Order{}
data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
) : Order

data class CoffeeOrder(
    val number: Int,
    val coffee: Coffee,
):Order

class PizzaStore {
    private var orderNumber = 0
    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val currentCoffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            coffee = currentCoffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza(name)
        val ingredients = getIngredient(pizza)
        if (ingredients.isEmpty()) {
            error("Неизвестный вид пиццы!")
        }
        return PizzaOrder(
            number = ++orderNumber,
            pizza = pizza,
        )
    }

    fun executeOrder(vararg orderList: Order) {
        for(currentOrder in orderList){
            when(currentOrder){
                is PizzaOrder -> pizzaMaker.makePizza(currentOrder)
                is CoffeeOrder -> barista.makeCoffee(currentOrder)
            }
        }
    }
}
