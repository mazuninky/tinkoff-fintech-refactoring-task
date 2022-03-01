package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.utils.InitializedMenus
import ru.tinkoff.fintech.refactoring.utils.InitializedPizzaCafe

fun main() {
    val initializedMenus = InitializedMenus()
    val ingredientMenu = initializedMenus.ingredientMenu

    val initializedPizzaCafe = InitializedPizzaCafe(initializedMenus = initializedMenus)
    val pizzaCafe = initializedPizzaCafe.pizzaCafe

    val order = setOf(
        pizzaCafe.order(MenuKind.PIZZA, "карбонара"),
        pizzaCafe.order(MenuKind.COFFEE, "эспрессо"),
    )
    pizzaCafe.executeOrder(order)

    printLine()

    ingredientMenu.get("яйца")!!.setPrice(100000.0)
    pizzaCafe.executeOrder(
        setOf(pizzaCafe.order(MenuKind.PIZZA, "карбонара"))
    )
}

private fun printLine() = print("\n\n---------------------------------------------------------\n\n")