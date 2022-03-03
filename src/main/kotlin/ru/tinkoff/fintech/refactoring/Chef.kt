package ru.tinkoff.fintech.refactoring

class Chef : PizzaMaker {
    override fun makePizza(orderId: Int, pizza: Pizza) {
        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
        println("[Пицца мейкер] Из ингредиентов:")
        pizza.ingredients.forEach { (ingredient, count) ->
            println("[Пицца мейкер] - ${ingredient.ingredientName}: в количестве $count за ${ingredient.price}$")
        }
        println("[Пицца мейкер] время приготовления ${pizza.getCookingTime()} минут")
        val roundedPrice = "%.2f".format(pizza.getPrice())
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ $orderId готов")
    }
}
