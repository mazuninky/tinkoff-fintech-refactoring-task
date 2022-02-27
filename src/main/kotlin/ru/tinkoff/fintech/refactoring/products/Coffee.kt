package ru.tinkoff.fintech.refactoring.products

import ru.tinkoff.fintech.refactoring.products.descriptions.CoffeeDescr

class Coffee(
    descr: CoffeeDescr,
    price: Double,
) : Product<CoffeeDescr>(descr, price, true) {
    override fun toString(): String {
        return "{${description.name} : ${description.brewTime.seconds}s}"
    }
}
