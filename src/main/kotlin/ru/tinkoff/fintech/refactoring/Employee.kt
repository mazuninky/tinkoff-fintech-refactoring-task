package ru.tinkoff.fintech.refactoring

interface Barista {
    fun makeCoffee(coffeeOrder: CoffeeOrder)
}

interface PizzaMaker {
    fun makePizza(pizzaOrder: PizzaOrder)
}

class OrderlyBarista : Barista {

    override fun makeCoffee(coffeeOrder: CoffeeOrder) {
        println("[Бариста] Готовлю напиток: ${coffeeOrder.coffee.name}")
        println("[Бариста] Время приготовления: ${coffeeOrder.coffee.brewTimeMinutes} минут")
        val roundedPrice = "%.2f".format(coffeeOrder.coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ ${coffeeOrder.number} готов")
    }
}

class OrderlyPizzaMaker : PizzaMaker {

    override fun makePizza(orderPizza: PizzaOrder) {
        println("[Пицца мейкер] Делаю пиццу: ${orderPizza.pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        var pizzaPrice = 0.0
        var ingredientCounter = 0
        orderPizza.pizza.ingredients.forEach {
            val ingredientName = it.first.name
            val price = it.first.price
            val ingredientCount = it.second

            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizzaPrice)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${orderPizza.number} готов")
    }
}
