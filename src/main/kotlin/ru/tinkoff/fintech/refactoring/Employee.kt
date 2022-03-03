package ru.tinkoff.fintech.refactoring

interface Employee {
    val empName: String

    fun makePizza(
        orderId: Int,
        pizza: Pizza
    ) { "Я не умею готовить пиццу".showPhrase() }

    fun makeCoffee(
        orderId: Int,
        coffee: Coffee
    ) { "Я не умею готовить кофе".showPhrase() }

    fun cleanFloor() { "Я не умею мыть полы".showPhrase() }

    fun String.showPhrase()
    {
        println("[$empName] $this")
    }
}
