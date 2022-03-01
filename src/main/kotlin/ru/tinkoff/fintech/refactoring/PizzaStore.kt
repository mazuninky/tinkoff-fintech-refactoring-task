package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
    val price: Double
)

data class CoffeeOrder(
    val number: Int,
    val coffee: Coffee,
    val price: Double
)

class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker: PizzaMaker = PizzaMaker()
    private val barista: Barista = Barista()

    fun orderCoffee(name: String) {
        val coffee = isCoffeeAvailable(name) ?: error("Неизвестный вид кофе!")
        val coffeeOrder = CoffeeOrder(++orderNumber, coffee, coffee.price)
        barista.makeCoffee(coffeeOrder)
    }

    fun orderPizza(name: String) {
        val pizza = isPizzaAvailable(name) ?: error("Такой пиццы нет!")
        val price = calculatePrice(pizza)
        val pizzaOrder = PizzaOrder(++orderNumber, pizza, price)
        pizzaMaker.makePizza(pizzaOrder)
    }

    fun calculatePrice(pizza: Pizza): Double {
        pizza.ingredients.forEach { (ingredient, amount) ->
            if (ingredient.remaining < amount) {
                error("Не достаточно ингредиентов!")
            }
        }
        var result = 0.00
        pizza.ingredients.forEach { (ingredient, amount) ->
            result += ingredient.price * amount
            ingredient.remaining -= amount
        }
        return result
    }

}