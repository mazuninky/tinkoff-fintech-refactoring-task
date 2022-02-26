package ru.tinkoff.fintech.refactoring

class Barista {
    fun makeCoffee(coffeeOrder: CoffeeOrder) {
        val coffee = coffeeOrder.coffee
        val orderId = coffeeOrder.number
        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${coffee.brewTimeInMinutes} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice$")

        println("[Бариста] заказ $orderId готов")
        println()
    }
}

class PizzaMaker() {
    private val ingredients = PizzaStore.ingredients

    fun makePizza(pizzaOrder: PizzaOrder) {
        val pizza = pizzaOrder.pizza
        val orderId = pizzaOrder.number
        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        var ingredientCounter = 0
        pizza.ingredients.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second
            val price = ingredients.getIngredientByName(ingredientName).price

            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizza.price)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ $orderId готов")
        println()
    }
}

class Cleaner() {
    fun cleanFloor() {
        println("[Уборщица] Убираюсь на кухне")
        println("[Уборщица] Убираюсь в зале")
        println("[Уборщица] Готово")
    }
}
