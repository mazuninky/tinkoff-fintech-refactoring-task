package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Product

interface Menu<T : Product> {
    val menu: Map<String, T>
    fun getNames(): Set<String> = menu.keys

    val menuKind: MenuKind

    val prices: MutableMap<String, Double?>
        get() {
            return menu.entries.fold(mutableMapOf()) { acc, curEntry ->
                acc[curEntry.key] = curEntry.value.getPrice().invoke()
                acc
            }
        }

    fun get(key: String): T? = menu[key]
}