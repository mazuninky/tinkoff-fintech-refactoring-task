package ru.tinkoff.fintech.refactoring

abstract class Employee(private val name: String) {
    protected fun doAction(action: String) {
        println("[$name] $action")
    }
}

class Barista : Employee("Бариста") {
    fun makeCoffee(order: CoffeeOrder) {
        doAction("Готовлю напиток: ${order.product.name}")
        doAction("Время приготовления: ${order.product.cookingTime} минут")
        doAction("Стоимость напитка: ${order.product.roundedPrice}")
        doAction("заказ ${order.number} готов")
    }
}

class PizzaMaker : Employee("Пицца мейкер") {
    fun makePizza(order: PizzaOrder) {
        doAction("Делаю пиццу: ${order.product.name}")
        doAction("Из ингридиетов:")
        order.product.ingredients.forEach {
            doAction("- ${it.ingredient.ingredientName}: в количестве ${it.count} за ${it.ingredient.price}$")
        }
        doAction("время приготовления ${order.product.cookingTime} минут")
        doAction("в сумме за все ${order.product.roundedPrice}$")
        doAction("заказ ${order.number} готов")
    }
}