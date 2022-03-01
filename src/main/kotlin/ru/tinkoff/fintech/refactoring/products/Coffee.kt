package ru.tinkoff.fintech.refactoring.products

import java.time.Duration

data class Coffee(
    override val name: String,
    val brewTime: Duration,
    val price: Double?,
) : Product(name, true) {
    override fun getPrice(): () -> Double? = { price }

    override fun toString(): String {
        return "{${name} : ${brewTime.seconds}s}"
    }
}
