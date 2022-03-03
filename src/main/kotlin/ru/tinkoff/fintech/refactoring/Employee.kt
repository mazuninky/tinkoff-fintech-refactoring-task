package ru.tinkoff.fintech.refactoring


class Barista{
    fun makeCoffee(orderId: Int, coffee: Coffee) {
        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${coffee.brewTime} минут")
        println("[Бариста] Стоимость напитка: ${"%.2f".format(coffee.price)}")
        println("[Бариста] заказ $orderId готов")
    }
}

class PizzaMaker {
    fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<String, Int>>) {
        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
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

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        println("[Пицца мейкер] в сумме за все ${"%.2f".format(pizzaPrice)}$")
        println("[Пицца мейкер] заказ $orderId готов")
    }
}