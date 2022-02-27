package ru.tinkoff.fintech.refactoring

abstract class Product(
    val name: String,
    val price: Double, // Не используется, но не стал делать private, так как цена нужна не только для вывода
    val cookingTime: Int,
) {
    val roundedPrice = "%.2f".format(price)
}