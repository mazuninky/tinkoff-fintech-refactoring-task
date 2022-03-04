package ru.tinkoff.fintech.refactoring

interface Barista {
    fun makeCoffee(coffeeOrder: CoffeeOrder): String
}

interface PizzaMaker {
    fun makePizza(pizzaOrder: PizzaOrder): String
}

class SimpleBarista : Barista {
    override fun makeCoffee(coffeeOrder: CoffeeOrder) =
        "[Бариста] Готовлю напиток: ${coffeeOrder.coffee.name}\n" +
                "[Бариста] Время приготовления: ${coffeeOrder.coffee.brewTimeInMinutes} минут\n" +
                "[Бариста] Стоимость напитка: " +
                "%.2f".format(coffeeOrder.coffee.price) + "\n" +
                "[Бариста] заказ ${coffeeOrder.orderId} готов\n"
}

class SimplePizzaMaker : PizzaMaker {
    override fun makePizza(pizzaOrder: PizzaOrder) =
        "[Пицца мейкер] Делаю пиццу: ${pizzaOrder.pizza.name}\n" +
                "[Пицца мейкер] Из ингредиентов:" + "\n" +
                countIngredientsAndPrice(pizzaOrder.pizza.ingredients) +
                "[Пицца мейкер] заказ ${pizzaOrder.orderId} готов\n"

    private fun countIngredientsAndPrice(ingredients: List<Pair<String, Int>>): String {
        var logs = ""
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

            logs += "[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$\n"
            pizzaPrice += price * ingredientCount
            ingredientCounter += ingredientCount
        }
        logs += "[Пицца мейкер] время приготовления $ingredientCounter минут\n" +
                "[Пицца мейкер] в сумме за все " + "%.2f".format(pizzaPrice) + "$\n"
        return logs
    }
}
