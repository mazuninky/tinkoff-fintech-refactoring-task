package ru.tinkoff.fintech.refactoring.stores

import ru.tinkoff.fintech.refactoring.assortment.Cappuccino
import ru.tinkoff.fintech.refactoring.assortment.Coffee
import ru.tinkoff.fintech.refactoring.assortment.Espresso

class CoffeeStore {
    companion object {
        fun getCoffeeByName(name: String): Coffee? {
            val coffeeStore = listOf(Espresso(), Cappuccino())
            return coffeeStore.find { it.name == name }
        }
    }
}
