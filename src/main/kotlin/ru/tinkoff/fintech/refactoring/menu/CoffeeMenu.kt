package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Coffee
import java.time.Duration

class CoffeeMenu(
    private val locaMenu: Map<String, Coffee>,
) : Menu<Coffee> {

    fun getBrewTime(name: String): Duration? {
        val coffee = menu[name]
        return coffee?.brewTime
    }

    override val menu: Map<String, Coffee>
        get() = locaMenu

    override val menuKind: MenuKind
        get() = MenuKind.COFFEE
}