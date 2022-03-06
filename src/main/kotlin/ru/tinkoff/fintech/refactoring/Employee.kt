package ru.tinkoff.fintech.refactoring

interface Employee<T> {
    fun make(order: T)
}

class Barista : Employee<CoffeeOrder> {
    override fun make(order: CoffeeOrder) {
        println("[Бариста] Готовлю напиток: ${order.coffee.productName}")
        println("[Бариста] Время приготовления: ${calculateCoffeeBrewTimeInMinutes(order.coffee)} минут")
        val roundedPrice = "%.2f".format(order.coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ ${order.number} готов")
    }
}

class PizzaMaker : Employee<PizzaOrder> {
    override fun make(order: PizzaOrder) {
        println("[Пицца мейкер] Делаю пиццу: ${order.pizza.productName}")
        println("[Пицца мейкер] Из ингридиетов:")
        var pizzaPrice = 0.0
        var ingredientCounter = 0
        order.pizza.ingredients.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second

            val price = getPriceForIngredient(ingredientName)

            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizzaPrice)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${order.number} готов")
    }


}