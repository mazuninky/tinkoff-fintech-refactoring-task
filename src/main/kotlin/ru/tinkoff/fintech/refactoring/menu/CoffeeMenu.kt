package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Coffee
import java.time.Duration

class CoffeeMenu(
    override val menu: Map<String, Coffee>
) : Menu<Coffee> {

    fun getBrewTime(name: String): Duration? {
        val coffee = menu[name]
        return coffee?.brewTime
    }

    override val menuKind: MenuKind
        get() = MenuKind.COFFEE
}