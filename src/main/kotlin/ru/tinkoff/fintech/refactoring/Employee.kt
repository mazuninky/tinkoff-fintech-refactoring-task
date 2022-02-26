//package ru.tinkoff.fintech.refactoring
//
//interface Employee {
//    fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<String, Int>>)
//    fun makeCoffee(orderId: Int, coffee: Coffee)
//    fun cleanFloor()
//}
//
//class Barista : Employee {
//    override fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<String, Int>>) {
//        println("[Бариста] Я не умею готовить пиццу")
//    }
//
//    override fun cleanFloor() {
//        println("[Бариста] Я не умею мыть полы")
//    }
//
//    override fun makeCoffee(orderId: Int, coffee: Coffee) {
//        println("[Бариста] Готовлю напиток: ${coffee.name}")
//        println("[Бариста] Время приготовления: ${calculateCoffeeBrewTimeInMinutes(coffee)} минут")
//        val roundedPrice = "%.2f".format(coffee.price)
//        println("[Бариста] Стоимость напитка: $roundedPrice")
//
//        println("[Бариста] заказ $orderId готов")
//    }
//}
//
//class PizzaMaker : Employee {
//    override fun makePizza(orderId: Int, pizza: Pizza, ingredients: List<Pair<String, Int>>) {
//        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
//        println("[Пицца мейкер] Из ингридиетов:")
//        var pizzaPrice = 0.0
//        var ingredientCounter = 0
//        ingredients.forEach {
//            val ingredientName = it.first
//            val ingredientCount = it.second
//
//            val price = when (ingredientName) {
//                "яйца" -> 3.48
//                "бекон" -> 6.48
//                "тесто" -> 1.00
//                "томат" -> 1.53
//                "оливки" -> 1.53
//                "сыр" -> 0.98
//                "пармезан" -> 3.98
//                "грибы" -> 3.34
//                "спаржа" -> 3.34
//                "мясное ассорти" -> 9.38
//                "вяленая говядина" -> 12.24
//                else -> error("Неизвестный ингредиент")
//            }
//
//            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
//            pizzaPrice += price * ingredientCount
//            ingredientCounter += ingredientCount
//        }
//
//        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
//        val roundedPrice = "%.2f".format(pizzaPrice)
//        println("[Пицца мейкер] в сумме за все $roundedPrice$")
//
//        println("[Пицца мейкер] заказ $orderId готов")
//    }
//
//    override fun makeCoffee(orderId: Int, coffee: Coffee) {
//        println("[Пицца мейкер] Я не умею готовить кофе")
//    }
//
//    override fun cleanFloor() {
//        println("[Пицца мейкер] Я не умею мыть полы")
//    }
//}
