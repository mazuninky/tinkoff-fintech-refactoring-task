package ru.tinkoff.fintech.refactoring.factories

import ru.tinkoff.fintech.refactoring.products.productsImpl.Coffee
import java.time.Duration

class CoffeeStore : Store<Coffee>(
    mutableMapOf(
        "эспрессо" to Coffee("эспрессо", 5.0, Duration.ofMinutes(5)),
        "капучино" to Coffee("капучино", 3.48, Duration.ofMinutes(6)),
    )
) {

    fun add(name: String, price: Double, brewTime: Duration) {
        if (data.containsKey(name)) throw IllegalArgumentException("Кофе $name уже в хранилище")
        data[name] = Coffee(name, price, brewTime)
    }

    fun add(coffee: Coffee) = add(coffee.name, coffee.price, coffee.brewTime)

    fun get(name: String) = data[name]

    fun getBrewTime(name: String): Duration {
        val coffee = data[name]
        return coffee?.brewTime ?: error("Неизвестный вид кофе")
    }
}