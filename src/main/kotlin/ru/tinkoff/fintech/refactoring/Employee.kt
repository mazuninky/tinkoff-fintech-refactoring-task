package ru.tinkoff.fintech.refactoring


class Barista{
    fun makeCoffee(orderId: Int, coffee: Coffee) {
        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${coffee.coffeeBrewTimeInMins()} минут")
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Стоимость напитка: $roundedPrice")

        println("[Бариста] заказ $orderId готов")
    }
}

class PizzaMaker{

    fun makePizza(pizzaOrder: PizzaOrder) {
        println("[Пицца мейкер] Делаю пиццу: ${pizzaOrder.pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        pizzaOrder.pizza.ingredients.forEach {

            if (it.food.name == "unknown food")
                error("Неизвестный ингредиент")

            println("[Пицца мейкер] - ${it.food.name}: в количестве ${it.count} за ${it.food.price}$")
        }

        println("[Пицца мейкер] время приготовления $ минут")
        val roundedPrice = "%.2f".format(pizzaOrder.pizza.getPrice())
        println("[Пицца мейкер] в сумме за все $roundedPrice$")

        println("[Пицца мейкер] заказ ${pizzaOrder.number} готов")
    }
}
