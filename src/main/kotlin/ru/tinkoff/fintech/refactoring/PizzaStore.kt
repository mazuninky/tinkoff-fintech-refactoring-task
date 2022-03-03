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

class CoffeeDepartment{

    private val barista: Barista = OrderlyBarista()

    fun getCoffeeByName(name: String): Coffee? {
        return Coffee.coffeeStore.find { it.name == name }
    }

    fun executeOrder(coffeeOrder: CoffeeOrder) {
        barista.makeCoffee(coffeeOrder)
    }
}

class PizzaDepartment {

    private val pizzaMaker: PizzaMaker = OrderlyPizzaMaker()

    fun getPizzaPrice(pizza: Pizza): Double {
        var pizzaPrice = 0.0
        pizza.ingredients.forEach {
            val ingredient = it.first
            val ingredientCount = it.second
            pizzaPrice += ingredient.price * ingredientCount
        }
        return pizzaPrice
    }

    fun executeOrder(pizzaOrder: PizzaOrder) {
        pizzaMaker.makePizza(pizzaOrder)
    }

}

class PizzaStore {
    var orderNumber = 0

    private val coffeeDepartment = CoffeeDepartment()
    private val pizzaDepartment = PizzaDepartment()

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = coffeeDepartment.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")

        return CoffeeOrder(
            number = ++orderNumber,
            coffee = coffee,
            price = coffee.price
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza(name)

        return PizzaOrder(
            number = ++orderNumber,
            pizza = pizza,
            price = pizzaDepartment.getPizzaPrice(pizza)
        )
    }

    fun executeOrder(pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null) {
        if (pizzaOrder != null) {
            pizzaDepartment.executeOrder(pizzaOrder)
        }

        if (coffeeOrder != null) {
            coffeeDepartment.executeOrder(coffeeOrder)
        }
    }
}