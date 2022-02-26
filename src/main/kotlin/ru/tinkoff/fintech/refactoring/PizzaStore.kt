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
    private var orderNumber = 0

    companion object{
        val ingredients = IngredientList()
    }

    val pizzaMenu = PizzaList()
    val coffeeMenu = CoffeeList()

    private val pizzaMaker: PizzaMaker = PizzaMaker()
    private val barista: Barista = Barista()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = coffeeMenu.getCoffeeByName(name)
        return CoffeeOrder(
            number = ++orderNumber,
            coffee = coffee,
            price = coffee.price
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = pizzaMenu.getPizzaByName(name)
        return PizzaOrder(
            number = ++orderNumber,
            pizza = pizza,
            price = pizza.price
        )
    }

    fun executeOrder(pizzaOrder: PizzaOrder) {
        pizzaMaker.makePizza(pizzaOrder)
    }

    fun executeOrder(coffeeOrder: CoffeeOrder) {
        barista.makeCoffee(coffeeOrder)
    }
}