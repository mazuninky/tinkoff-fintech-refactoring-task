package ru.tinkoff.fintech.refactoring

fun String.showPhrase(empName: String)
{
    println("[$empName] $this")
}

interface BaristaInterface
{
    fun makeCoffee(
        orderId: Int,
        coffee: Coffee
    )
}

interface PizzaMakerInterface
{
    fun makePizza(
        orderId: Int,
        pizza: Pizza,
    )
}

class Barista : BaristaInterface {
    private val empName = "Бариста"

    override fun makeCoffee(
        orderId: Int,
        coffee: Coffee
    ) {
        "Готовлю напиток: ${coffee.name}".showPhrase(empName)
        "Время приготовления: ${coffee.brewTimeInMinutes} минут".showPhrase(empName)
        val roundedPrice = "%.2f".format(coffee.price)
        "Стоимость напитка: $roundedPrice".showPhrase(empName)
        "Заказ $orderId готов".showPhrase(empName)
    }
}
class PizzaMaker : PizzaMakerInterface {
    private val empName = "Пицца мейкер"

    override fun makePizza(
        orderId: Int,
        pizza: Pizza,
    ) {
        "Делаю пиццу: ${pizza.name}".showPhrase(empName)
        "Из ингридиетов:".showPhrase(empName)
        var ingredientCounter = 0
        pizza.ingredients.forEach {
            "- ${it.first.name}: в количестве ${it.second} за ${it.first.price}$".showPhrase(empName)
            pizza.price += it.first.price * it.second
            ingredientCounter += it.second
        }

        "Время приготовления $ingredientCounter минут".showPhrase(empName)
        val roundedPrice = "%.2f".format(pizza.price)
        "В сумме за все $roundedPrice$".showPhrase(empName)

        "Заказ $orderId готов".showPhrase(empName)
    }
}
