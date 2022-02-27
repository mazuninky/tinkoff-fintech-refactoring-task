package ru.tinkoff.fintech.refactoring


class Coffee(val name: String) {
    private var coffeeMenu = mutableMapOf(
        "эспрессо" to CoffeeInfoPriceTime(5.0, 5),
        "капучино" to CoffeeInfoPriceTime(3.48, 6))


    fun getCoffeeInfoPriceTime() = coffeeMenu[name] ?: CoffeeInfoPriceTime(0.0, 0)
    // fun addInCoffeeMenu
}

data class CoffeeInfoPriceTime(val priceProduct: Double, val timeInMinutesProduct: Int)

class CoffeeOrder(private val numberOrder: Int, private val coffee: Coffee) {
    fun getNumberOrder() = numberOrder
    fun getNameCoffee() = coffee.name
    fun getPriceCoffee() = coffee.getCoffeeInfoPriceTime().priceProduct
    fun getTimeInMinutesCoffee() = coffee.getCoffeeInfoPriceTime().timeInMinutesProduct

}

