package ru.tinkoff.fintech.refactoring.store.employees.containersForWork

data class Order(
    val type: String,
    val name: String,
    override val orderId: Int,
    val price: Double
) : CafeContainer(orderId)
