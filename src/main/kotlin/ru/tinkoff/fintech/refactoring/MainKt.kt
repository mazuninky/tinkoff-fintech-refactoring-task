package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.store.PizzaCafe

fun main() {
    val ingredientMenu = getIngredientMenu()

    val mainMenu = mapOf(
        MenuKind.DISH to getPizzaMenu(ingredientMenu),
        MenuKind.INGREDIENT to ingredientMenu,
        MenuKind.COFFEE to getCoffeMenu(),
    )


    val workers = getWorkers(mainMenu)

    val pizzaCafe = PizzaCafe(mainMenu, workers)

    val order = setOf(
        pizzaCafe.order(MenuKind.DISH, "карбонара"),
        pizzaCafe.order(MenuKind.COFFEE, "эспрессо"),
    )
    pizzaCafe.executeOrder(order)

    printLine()

    ingredientMenu.get("яйца")!!.setPrice(100000.0)
    pizzaCafe.executeOrder(
        setOf(pizzaCafe.order(MenuKind.DISH, "карбонара"))
    )
}

private fun printLine() = print("\n\n---------------------------------------------------------\n\n")