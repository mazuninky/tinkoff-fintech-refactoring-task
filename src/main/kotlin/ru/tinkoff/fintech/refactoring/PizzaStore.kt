package ru.tinkoff.fintech.refactoring

class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker: PizzaMaker = PizzaMaker()
    private val barista: Barista = Barista()
    private val storage = Storage(
        mapOf(
            Ingredient.EGG to 10,
            Ingredient.BACON to 10,
            Ingredient.DOUGH to 10,
            Ingredient.CHEESE to 4
        )
    )


    fun orderCoffee(name: String) {
        val coffee = Coffee.findCoffee(name)
        if (coffee == null) {
            println("такого кофе нет!")
        } else {
            val coffeeOrder = CoffeeOrder(++orderNumber, coffee, coffee.price)
            barista.doWork(coffeeOrder)
        }
    }

    fun orderPizza(name: String) {
        val pizza = Pizza.findPizza(name)
        if (pizza == null) {
            println("Такой пиццы нет!")
        } else if (notEnoughIngredients(pizza)) {
            println("не достаточно ингредиентов!")
        } else {
            val price = pizza.price
            val pizzaOrder = PizzaOrder(++orderNumber, pizza, price)
            storage.takeIngredientForPizza(pizza)
            pizzaMaker.doWork(pizzaOrder)
        }
    }

    fun notEnoughIngredients(pizza: Pizza): Boolean =
        pizza.ingredients.any { (ingredients, amount) ->
            storage.getRemainder(ingredients) < amount
        }
}