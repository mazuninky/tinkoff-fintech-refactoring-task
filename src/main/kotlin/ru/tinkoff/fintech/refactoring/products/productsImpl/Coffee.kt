package ru.tinkoff.fintech.refactoring.products.productsImpl

import ru.tinkoff.fintech.refactoring.products.abstractProducts.Drink
import java.time.Duration

class Coffee(
    name: String,
    price: Double,
    val brewTime: Duration
) : Drink(name, price)
