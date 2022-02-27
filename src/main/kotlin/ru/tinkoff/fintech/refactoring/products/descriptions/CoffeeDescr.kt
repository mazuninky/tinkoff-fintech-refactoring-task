package ru.tinkoff.fintech.refactoring.products.descriptions

import java.time.Duration

class CoffeeDescr(
    override val name: String,
    val brewTime: Duration
) : Description