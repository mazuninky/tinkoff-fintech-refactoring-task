package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Product

abstract class Menu<T : Product>(
    open val menu: Map<String, T>
) {
    fun getNames(): Set<String> = menu.keys

    abstract val menuKind: MenuKind

    fun get(key: String): T? = menu[key]
}