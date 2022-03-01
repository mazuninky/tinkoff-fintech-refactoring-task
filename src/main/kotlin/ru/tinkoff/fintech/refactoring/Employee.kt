package ru.tinkoff.fintech.refactoring

class Barista {
    fun makeCoffee(coffeeOrder: CoffeeOrder) {
        println("[Бариста] Готовлю напиток: ${coffeeOrder.coffee.value}")
        println("[Бариста] Время приготовления: ${coffeeOrder.coffee.time} минут")
        val roundedPrice = "%.2f".format(coffeeOrder.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ ${coffeeOrder.number} готов")
    }
}

class PizzaMaker {
    fun makePizza(pizzaOrder: PizzaOrder) {
        println("[Пицца мейкер] Делаю пиццу: ${pizzaOrder.pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        var ingredientCounter = 0
        pizzaOrder.pizza.ingredients.forEach { (ingredient, ingredientCount) ->
            println("[Пицца мейкер] - ${ingredient.value}: в количестве $ingredientCount за ${ingredient.price}$")
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizzaOrder.price)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${pizzaOrder.number} готов")
    }

}
