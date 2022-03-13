package ru.tinkoff.fintech.refactoring

interface Employee {
    fun roundPrice(price : Double) : String{
        return "%.2f".format(price)
    }
}

interface BaristaEmployee : Employee {
    fun makeCoffee(orderId: Int, coffee: Coffee)
}

interface PizzaMakerEmployee : Employee {
    fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<String, Int>>)
}

interface FloorCleanerEmlpoyee : Employee {
    fun cleanFloor()
}

class Barista : BaristaEmployee {
    override fun makeCoffee(orderId: Int, coffee: Coffee) {
        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${calculateCoffeeBrewTimeInMinutes(coffee)} минут")
        println("[Бариста] Стоимость напитка: ${roundPrice(coffee.price)}")

        println("[Бариста] заказ $orderId готов")
    }
}

class PizzaMaker : PizzaMakerEmployee {
    override fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<String, Int>>) {
        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")
        val orderInfo = getPizzaOrderInfo(ingredients, "make")
        val pizzaPrice = orderInfo.pizzaPrice
        val ingredientCounter = orderInfo.ingredientCounter

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        println("[Пицца мейкер] в сумме за все ${roundPrice(pizzaPrice)}$")

        println("[Пицца мейкер] заказ $orderId готов")
    }

}
