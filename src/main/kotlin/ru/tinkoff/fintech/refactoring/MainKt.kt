package ru.tinkoff.fintech.refactoring

fun main() {
    val pizzaStore = PizzaStore()
    //  val pizzaOrder = pizzaStore.orderPizza("карбонара")
    //  val coffeeOrder = pizzaStore.orderCoffee("эспрессо")
    //  pizzaStore.executeOrder(pizzaOrder, coffeeOrder)

    println(pizzaStore.executeOrderBarista("эспрессо"))
    println(pizzaStore.executeOrderBarista("капучино"))
    println(pizzaStore.executeOrderBarista(""))
    println(pizzaStore.executeOrderPizzaMaker("маринара"))
    println(pizzaStore.executeOrderPizzaMaker("крестьянская"))
    println(pizzaStore.executeOrderPizzaMaker(""))
}