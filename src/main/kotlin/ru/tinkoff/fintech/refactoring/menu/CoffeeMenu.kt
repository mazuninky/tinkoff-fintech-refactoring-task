package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Coffee
import java.time.Duration

class CoffeeMenu : Menu<Coffee> {
    private val localMenu = setOf(
        Coffee("эспрессо", Duration.ofMinutes(5), 5.0),
        Coffee("капучино", Duration.ofMinutes(6), 3.48),
    ).associateBy { it.name }

    fun getBrewTime(name: String): Duration? {
        val coffee = menu[name]
        return coffee?.brewTime
    }

    override val menu: Map<String, Coffee>
        get() = localMenu
}