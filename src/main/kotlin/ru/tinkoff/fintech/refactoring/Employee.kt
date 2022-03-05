package ru.tinkoff.fintech.refactoring


interface Barista {
    fun makeCoffee(coffeeOrder: CoffeeOrder)
}

interface PizzaMaker {
    fun makePizza(pizzaOrder: PizzaOrder)
}

interface Cleaner {
    fun cleanFloor()
}

class BaristaImpl: Barista {
    override fun makeCoffee(coffeeOrder: CoffeeOrder) {
        println("[Бариста] Готовлю напиток: ${coffeeOrder.coffee.name}")
        println("[Бариста] Время приготовления: ${coffeeOrder.coffee.brewTimeInMins} минут")
        val roundedPrice = "%.2f".format(coffeeOrder.coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ ${coffeeOrder.orderID} готов")
    }
}

class PizzaMakerImpl: PizzaMaker{
    override fun makePizza(pizzaOrder: PizzaOrder) {
        println("[Пицца мейкер] Делаю пиццу: ${pizzaOrder.pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        pizzaOrder.pizza.ingredients.forEach {

            if (it.food.name == "unknown food")
                error("Неизвестный ингредиент")

            println("[Пицца мейкер] - ${it.food.name}: в количестве ${it.count} за ${it.food.price}$")
        }

        println("[Пицца мейкер] время приготовления $ минут")
        val roundedPrice = "%.2f".format(pizzaOrder.pizza.price)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${pizzaOrder.orderID} готов")
    }
}
