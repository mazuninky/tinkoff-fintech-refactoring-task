package ru.tinkoff.fintech.refactoring

interface Employee {
    fun makeJob(order: Order)
}

class Barista : Employee {

    override fun makeJob(order: Order) {
        val coffeeOrder = order as CoffeeOrder
        println("[Бариста] Готовлю напиток: ${coffeeOrder.coffee.coffeeName}")
        println("[Бариста] Время приготовления: ${coffeeOrder.coffee.brewTime} минут")
        val roundedPrice = "%.2f".format(coffeeOrder.coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ ${coffeeOrder.number} готов")
    }
}

class PizzaMaker : Employee {

    override fun makeJob(order: Order) {
        val pizzaOrder = order as PizzaOrder
        println("[Пицца мейкер] Делаю пиццу: ${pizzaOrder.pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        val ingredientCount = printIngredients(pizzaOrder.pizza.getIngredient())

        println("[Пицца мейкер] время приготовления $ingredientCount минут")
        val roundedPrice = "%.2f".format(pizzaOrder.price)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${pizzaOrder.number} готов")
    }

    private fun printIngredients(ingredients: List<Pair<String, Int>>): Int {
        var ingredientCounter = 0
        ingredients.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second
            val ingredientForPrice = Ingredient.getIngredientByName(ingredientName)

            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за ${ingredientForPrice?.price}$")
            ingredientCounter += ingredientCount
        }
        return ingredientCounter
    }
}
