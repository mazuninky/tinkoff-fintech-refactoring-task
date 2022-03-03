package ru.tinkoff.fintech.refactoring

class PizzaMaker : Employee {
    override val empName = "Пицца мейкер"

    override fun makePizza(
        orderId: Int,
        pizza: Pizza,
    ) {
        "Делаю пиццу: ${pizza.name}".showPhrase()
        "Из ингридиетов:".showPhrase()
        var ingredientCounter = 0
        pizza.ingredients.forEach {
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

            "- ${ingredientName}: в количестве $ingredientCount за $price$".showPhrase()
            pizza.price += price * ingredientCount
            ingredientCounter += ingredientCount
        }

        "Время приготовления $ingredientCounter минут".showPhrase()
        val roundedPrice = "%.2f".format(pizza.price)
        "В сумме за все $roundedPrice$".showPhrase()

        "Заказ $orderId готов".showPhrase()
    }
}