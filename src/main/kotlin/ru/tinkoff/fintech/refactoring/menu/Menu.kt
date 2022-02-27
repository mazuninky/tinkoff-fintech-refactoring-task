package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Product

interface Menu<PRODUCT_T : Product<*>> {
    val menu: Map<String, PRODUCT_T>
    fun getNames(): Set<String> = getPrices().keys
    fun getPrices(): Map<String, Double?> = menu.mapValues {
        val product = it.value
        product.price
    }

    fun getPrice(key: String): Double? = getPrices()[key]
}