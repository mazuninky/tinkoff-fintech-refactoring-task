package ru.tinkoff.fintech.refactoring.employee


import ru.tinkoff.fintech.refactoring.menu.IngredientDAO
import ru.tinkoff.fintech.refactoring.menu.IngredientDAOImpl
import ru.tinkoff.fintech.refactoring.menu.Pizza


interface PizzaMaker {
    fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<String, Int>>)
}

class PizzaMakerImpl : PizzaMaker {

    private val ingredientDAO: IngredientDAO = IngredientDAOImpl()

    override fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<String, Int>>) {

        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        var pizzaPrice = 0.0
        var ingredientCounter = 0
        ingredients.forEach {
            val ingredientName = it.first

            val ingredient = ingredientDAO.getIngredientByName(ingredientName)
                ?: error("Неизвестный ингердиент!")

            val ingredientCount = it.second

            val price = ingredient.price

            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizzaPrice)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ $orderId готов")
    }
}
