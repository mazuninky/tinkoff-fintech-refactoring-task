package ru.tinkoff.fintech.refactoring.products

import ru.tinkoff.fintech.refactoring.products.descriptions.Description
import ru.tinkoff.fintech.refactoring.utils.WithAvailability

abstract class Product<DESCR_T : Description>(
    open val description: DESCR_T,
    open val price: Double? = null,
    protected var enabled: Boolean = false
) : WithAvailability {
    final override fun isEnabled(): Boolean = enabled
}