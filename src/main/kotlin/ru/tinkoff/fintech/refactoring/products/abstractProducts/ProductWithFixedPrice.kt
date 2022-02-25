package ru.tinkoff.fintech.refactoring.products.abstractProducts

abstract class ProductWithFixedPrice(override val name: String, override val price: Double) : Product {
}