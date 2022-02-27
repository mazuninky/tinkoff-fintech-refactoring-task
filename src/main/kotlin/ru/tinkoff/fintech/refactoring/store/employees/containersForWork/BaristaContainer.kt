package ru.tinkoff.fintech.refactoring.store.employees.containersForWork

import ru.tinkoff.fintech.refactoring.products.Coffee

class BaristaContainer(
    orderId: Int,
    val coffee: Coffee,
) : CafeContainer(orderId)
