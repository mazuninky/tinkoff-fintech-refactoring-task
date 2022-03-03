package ru.tinkoff.fintech.refactoring.stores

import ru.tinkoff.fintech.refactoring.Cappuccino
import ru.tinkoff.fintech.refactoring.Coffee
import ru.tinkoff.fintech.refactoring.Espresso

class CoffeeStore {
    companion object {
        private val coffeeStore = listOf(Espresso(), Cappuccino())

        fun getCoffeeByName(name: String): Coffee? {
            return coffeeStore.find { it.name == name }
        }
    }
}
