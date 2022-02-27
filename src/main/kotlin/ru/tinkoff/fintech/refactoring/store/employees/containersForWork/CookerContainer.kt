package ru.tinkoff.fintech.refactoring.store.employees.containersForWork

import ru.tinkoff.fintech.refactoring.products.Dish

class CookerContainer(
    orderId: Int,
    val dish: Dish,
) : CafeContainer(orderId)