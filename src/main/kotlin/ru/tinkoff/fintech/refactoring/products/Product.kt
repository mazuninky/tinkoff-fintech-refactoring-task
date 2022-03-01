package ru.tinkoff.fintech.refactoring.products

abstract class Product(
    open val name: String,
    protected open var enabled: Boolean = false
) {
    abstract fun getPrice(): () -> Double?
    fun isEnabled(): Boolean = enabled
}