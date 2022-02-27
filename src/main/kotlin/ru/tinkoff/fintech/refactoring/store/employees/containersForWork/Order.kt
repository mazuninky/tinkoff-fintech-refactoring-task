package ru.tinkoff.fintech.refactoring.store.employees.containersForWork

import ru.tinkoff.fintech.refactoring.menu.MenuKind

data class Order(
    val type: MenuKind,
    val name: String,
    override val orderId: Int,
    val price: Double
) : CafeContainer(orderId)
