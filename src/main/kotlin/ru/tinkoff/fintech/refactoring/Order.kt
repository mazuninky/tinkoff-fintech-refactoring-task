package ru.tinkoff.fintech.refactoring

data class Order(
    val type: OrderType,
    val name: String,
    val orderId: Int,
) {
    enum class OrderType {
        PIZZA,
        COFFEE,
    }
}

