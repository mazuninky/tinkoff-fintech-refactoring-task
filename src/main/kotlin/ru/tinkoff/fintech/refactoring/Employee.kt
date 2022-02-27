package ru.tinkoff.fintech.refactoring

interface Employee {              // open-closed principle

    fun workInfo(): String

}

class Barista(private val coffeeOrder: CoffeeOrder) : Employee {

    private val roundedPrice = "%.2f".format(coffeeOrder.getPriceCoffee())

    private var textWorkExecute = listOf(
        "[Бариста] Готовлю напиток: ${coffeeOrder.getNameCoffee()}",
        "[Бариста] Время приготовления: ${coffeeOrder.getTimeInMinutesCoffee()} минут",
        "[Бариста] Стоимость напитка: $roundedPrice$",
        "[Бариста] Заказ ${coffeeOrder.getNumberOrder()} готов\n").joinToString("\n")

    private var textWorkFail = listOf(
        "[Бариста] Какой экзотический кофе: ${coffeeOrder.getNameCoffee()}!",
        "[Бариста] Заказ ${coffeeOrder.getNumberOrder()} отклонен\n").joinToString("\n")

    override fun workInfo() = when (coffeeOrder.getTimeInMinutesCoffee()) {
        0 -> textWorkFail
        else -> textWorkExecute
    }
}

class CleanWoman : Employee {
    override fun workInfo() = listOf("[Уборщица] Ну что опять!?",
        "[Уборщица] ...ворчание...",
        "[Уборщица] Уборка закончена!\n").joinToString("\n")
}

class PizzaMaker(private val pizzaOrder: PizzaOrder) : Employee {

    private val roundedPrice = "%.2f".format(pizzaOrder.getPricePizza())

    private var textWorkExecute = listOf(
        "[Пицца мейкер] Делаю пиццу: ${pizzaOrder.getNamePizza()}",
        "[Пицца мейкер] Из ингридиетов:",
        pizzaOrder.getTextIngredientWithPrice(),
        "[Пицца мейкер] время приготовления ${pizzaOrder.getTimeInMinutesPizza()} минут",
        "[Пицца мейкер] в сумме за все $roundedPrice$",
        "[Пицца мейкер] заказ ${pizzaOrder.getNumberOrder()} готов\n").joinToString("\n")

    private var textWorkFail = listOf(
        "[Пицца мейкер] Новый тренд в мире пиццы: ${pizzaOrder.getNamePizza()}!",
        "[Пицца мейкер] Заказ ${pizzaOrder.getNumberOrder()} отклонен\n").joinToString("\n")

    override fun workInfo() = when (pizzaOrder.getTimeInMinutesPizza()) {
        0 -> textWorkFail
        else -> textWorkExecute
    }
}






