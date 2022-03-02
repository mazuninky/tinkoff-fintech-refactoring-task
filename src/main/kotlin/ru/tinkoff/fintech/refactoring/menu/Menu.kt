package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Product

abstract class Menu<T : Product>(
    open val menu: Map<String, T>
) {
    fun getNames(): Set<String> = menu.keys

    abstract val menuKind: MenuKind

    val prices: MutableMap<String, Double?>
        get() = menu.mapValues { it.value.getPrice().invoke() }.toMutableMap()

    fun get(key: String): T? = menu[key]
}