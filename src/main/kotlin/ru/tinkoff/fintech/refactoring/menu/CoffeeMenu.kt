package ru.tinkoff.fintech.refactoring.menu//package ru.tinkoff.fintech.refactoring.factories

import ru.tinkoff.fintech.refactoring.products.descriptions.CoffeeDescr
import ru.tinkoff.fintech.refactoring.products.Coffee
import java.time.Duration

class CoffeeMenu : Menu<Coffee> {
    private val localMenu = setOf(
        CoffeeDescr("эспрессо", Duration.ofMinutes(5)) to 5.0 * 60,
        CoffeeDescr("капучино", Duration.ofMinutes(6)) to 3.48 * 60,
    ).associateBy { it.first.name }.mapValues {
        val descr = it.value.first
        val price = it.value.second
        Coffee(descr, price)
    }

    fun getBrewTime(name: String): Duration? {
        val coffee = menu[name]
        return coffee?.description?.brewTime
    }

    override val menu: Map<String, Coffee>
        get() = localMenu
}