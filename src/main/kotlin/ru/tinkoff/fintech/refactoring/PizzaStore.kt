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
    private val storage: Storage =
        Storage(
            mutableMapOf(
                Ingredient.EGG to 5,
                Ingredient.BECKON to 10,
                Ingredient.DOUGH to 4,
                Ingredient.CHEESE to 5
            )
        )


    fun orderCoffee(unformattedName: String) {
        val name = unformattedName.lowercase()
        val coffee = Coffee.isCoffeeAvailable(name) ?: println("такого кофе нет!")
        if (!(coffee is Coffee)) {
            return
        }
        val coffeeOrder = CoffeeOrder(++orderNumber, coffee, coffee.price)
        barista.makeCoffee(coffeeOrder)
    }

    fun orderPizza(unformattedName: String) {
        val name = unformattedName.lowercase()
        val pizza = Pizza.isPizzaAvailable(name) ?: println("Такой пиццы нет!")
        if (!(pizza is Pizza)) {
            return
        }
        if (!isEnoughIngredients(pizza)) {
            return
        }
        val price = calculatePrice(pizza)
        val pizzaOrder = PizzaOrder(++orderNumber, pizza, price)
        pizzaMaker.makePizza(pizzaOrder)
    }

    fun calculatePrice(pizza: Pizza): Double {
        var result = 0.00
        pizza.ingredients.forEach { (ingredient, amount) ->
            result += ingredient.price * amount
            storage.takeIngredient(ingredient, amount)
        }
        return result
    }

    fun isEnoughIngredients(pizza: Pizza): Boolean {
        pizza.ingredients.forEach { (ingredients, amount) ->
            if (storage.getRemainder(ingredients) < amount) {
                println("не достаточно ингредиентов!")
                return false
            }
        }
        return true
    }
}