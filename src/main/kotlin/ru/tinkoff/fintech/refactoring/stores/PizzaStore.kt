package ru.tinkoff.fintech.refactoring.stores

import ru.tinkoff.fintech.refactoring.assortment.*

class PizzaStore {
    private val pizzaStore = listOf(Carbonara(), Marinara(), Sardinia(), Valtellina(), Peasant())

    fun getPizzaByName(name: String): Pizza? {
        return pizzaStore.find { it.name == name }
    }
}
