package ru.tinkoff.fintech.refactoring

abstract class Store(var orderNumber : Int = 0) {
    abstract fun executeOrder(order: Order? = null)
}