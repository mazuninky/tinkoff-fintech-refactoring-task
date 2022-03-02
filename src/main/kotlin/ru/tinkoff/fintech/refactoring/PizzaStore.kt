package ru.tinkoff.fintech.refactoring

class PizzaStore {
    var orderNumber = 0

    private val pizzaMaker: PizzaMaker = PizzaMaker()
    private val barista: Barista = Barista()
    private val storage = Storage(
        mutableMapOf(
            Ingredient.EGG to 5,
            Ingredient.BACON to 10,
            Ingredient.DOUGH to 4,
            Ingredient.CHEESE to 5
        )
    )


    fun orderCoffee(name: String) {
        val coffee = Coffee.findCoffee(name.lowercase()) ?: null
        if (coffee == null) {
            println("такого кофе нет!")
            return
        }
        val coffeeOrder = CoffeeOrder(++orderNumber, coffee, coffee.price)
        barista.doWork(coffeeOrder)
    }

    fun orderPizza(name: String) {
        val pizza = Pizza.findPizza(name.lowercase()) ?: null
        if (pizza == null) {
            println("Такой пиццы нет!")
            return
        }
        if (!isEnoughIngredients(pizza)) {
            return
        }
        val price = calculatePrice(pizza)
        val pizzaOrder = PizzaOrder(++orderNumber, pizza, price)
        pizzaMaker.doWork(pizzaOrder)
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