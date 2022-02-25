package ru.tinkoff.fintech.refactoring.products.abstractProducts

abstract class Drink(name: String, price: Double) : ProductWithFixedPrice(name, price), Food