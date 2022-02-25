package ru.tinkoff.fintech.refactoring.factories

import ru.tinkoff.fintech.refactoring.products.productsImpl.Ingredient

abstract class Store<T>(
    protected val data: MutableMap<String, T>
) {
    fun getStore() : Map<String, T> {
        return data.toMap()
    }
}