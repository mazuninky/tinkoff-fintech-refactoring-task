package ru.tinkoff.fintech.refactoring

interface Employee {
    val employeeTypeRu: String

    fun makePizza(pizzaOrder: PizzaOrder) {
        println("[$employeeTypeRu] Я не умею готовить пиццу")
    }

    fun makeCoffee(coffeeOrder: CoffeeOrder){
        println("[$employeeTypeRu] Я не умею готовить пиццу")
    }

    fun cleanFloor() {
        println("[$employeeTypeRu] Я не умею мыть полы")
    }
}

class Barista: Employee{
    override val employeeTypeRu = "Бариста"

    override fun makeCoffee(coffeeOrder: CoffeeOrder) {
        println("[$employeeTypeRu] Готовлю напиток: ${coffeeOrder.coffee.name}")
        println("[$employeeTypeRu] Время приготовления: ${coffeeOrder.coffee.brewTimeInMins} минут")
        val roundedPrice = "%.2f".format(coffeeOrder.coffee.price)
        println("[$employeeTypeRu] Стоимость напитка: $roundedPrice")

        println("[$employeeTypeRu] заказ ${coffeeOrder.orderID} готов")
    }
}

class PizzaMaker: Employee{
    override val employeeTypeRu = "Пицца мейкер"

    override fun makePizza(pizzaOrder: PizzaOrder) {
        println("[$employeeTypeRu] Делаю пиццу: ${pizzaOrder.pizza.name}")
        println("[$employeeTypeRu] Из ингридиетов:")
        pizzaOrder.pizza.ingredients.forEach {

            if (it.food.name == "unknown food")
                error("Неизвестный ингредиент")

            println("[$employeeTypeRu] - ${it.food.name}: в количестве ${it.count} за ${it.food.price}$")
        }

        println("[$employeeTypeRu] время приготовления $ минут")
        val roundedPrice = "%.2f".format(pizzaOrder.pizza.price)
        println("[$employeeTypeRu] в сумме за все $roundedPrice$")

        println("[$employeeTypeRu] заказ ${pizzaOrder.orderID} готов")
    }
}
