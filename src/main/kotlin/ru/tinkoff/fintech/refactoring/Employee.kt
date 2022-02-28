package ru.tinkoff.fintech.refactoring

interface Barista {
    fun makeCoffee(coffeeOrder: CoffeeOrder)
}

interface PizzaMaker {
    fun makePizza(pizzaOrder: PizzaOrder)
}

class BaristaImpl : Barista {
    override fun makeCoffee(coffeeOrder: CoffeeOrder) {
        println("[Бариста] Готовлю напиток: ${coffeeOrder.coffee.name}")
        println("[Бариста] Время приготовления: ${coffeeOrder.coffee.brewTimeInMinutes} минут")
        val roundedPrice = "%.2f".format(coffeeOrder.coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ ${coffeeOrder.orderId} готов")
    }
}

class PizzaMakerImpl : PizzaMaker {
    override fun makePizza(pizzaOrder: PizzaOrder) {
        println("[Пицца мейкер] Делаю пиццу: ${pizzaOrder.pizza.name}")
        println("[Пицца мейкер] Из ингредиентов:")

        val counterAndPrice = countIngredientsAndPrice(pizzaOrder.pizza.ingredients)
        println("[Пицца мейкер] время приготовления ${counterAndPrice.first} минут")
        val roundedPrice = "%.2f".format(counterAndPrice.second)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${pizzaOrder.orderId} готов")
    }

    private fun countIngredientsAndPrice(ingredients: List<Pair<String, Int>>): Pair<Int, Double> {
        var pizzaPrice = 0.0
        var ingredientCounter = 0
        ingredients.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second

            val price = when (ingredientName) {
                "яйца" -> 3.48
                "бекон" -> 6.48
                "тесто" -> 1.00
                "томат" -> 1.53
                "оливки" -> 1.53
                "сыр" -> 0.98
                "пармезан" -> 3.98
                "грибы" -> 3.34
                "спаржа" -> 3.34
                "мясное ассорти" -> 9.38
                "вяленая говядина" -> 12.24
                else -> error("Неизвестный ингредиент")
            }

            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounter += ingredientCount
        }
        return Pair(ingredientCounter, pizzaPrice)
    }
}
