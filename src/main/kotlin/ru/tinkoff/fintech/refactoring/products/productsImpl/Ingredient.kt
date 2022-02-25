package ru.tinkoff.fintech.refactoring.products.productsImpl

import ru.tinkoff.fintech.refactoring.products.abstractProducts.Food
import ru.tinkoff.fintech.refactoring.products.abstractProducts.ProductWithFixedPrice

class Ingredient (name: String, price: Double) : ProductWithFixedPrice(name, price), Food