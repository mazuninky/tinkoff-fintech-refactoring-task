package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.stores.Store

fun main() {
    val store = Store()
    store.orderPizza("карбонара")
    store.orderCoffee("эспрессо")
    store.execute()
}
