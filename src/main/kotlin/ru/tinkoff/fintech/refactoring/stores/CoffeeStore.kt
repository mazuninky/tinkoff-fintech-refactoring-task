package ru.tinkoff.fintech.refactoring.stores

import ru.tinkoff.fintech.refactoring.assortment.Cappuccino
import ru.tinkoff.fintech.refactoring.assortment.Coffee
import ru.tinkoff.fintech.refactoring.assortment.Espresso

class CoffeeStore {
    private val coffeeStore = listOf(Espresso(), Cappuccino())

    fun getCoffeeByName(name: String): Coffee? {
        return coffeeStore.find { it.name == name }
    }
}
