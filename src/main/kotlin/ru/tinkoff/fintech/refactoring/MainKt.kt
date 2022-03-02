package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.store.PizzaCafe

fun main() {
    val factory = MainUtilFactory()

    val ingredientMenu = factory.createIngredientMenu()

    val mainMenu = mapOf(
        MenuKind.DISH to factory.createPizzaMenu(ingredientMenu),
        MenuKind.INGREDIENT to ingredientMenu,
        MenuKind.COFFEE to factory.createCoffeMenu(),
    )

    val workers = factory.createWorkers(mainMenu)

    val pizzaCafe = PizzaCafe(mainMenu, workers)

    val pizzaz = listOf("карбонара", "сардиния")
    val pizzaOrders = pizzaz.mapNotNull { name ->
        try {
            pizzaCafe.order(MenuKind.DISH, name)
        } catch (ex: IllegalStateException) {
            println(ex.message)
            print("\n")
            null
        }
    }

    val coffees = listOf("эспрессо", "эспрессо".reversed())
    val coffeeOrders = coffees.mapNotNull { name ->
        try {
            pizzaCafe.order(MenuKind.COFFEE, name)
        } catch (ex: IllegalStateException) {
            println(ex.message)
            print("\n")
            null
        }
    }

    val order = setOf(
        pizzaOrders, coffeeOrders
    ).flatten().toSet()

    pizzaCafe.executeOrder(order)

    printLine()

    ingredientMenu.get("яйца")!!.setPrice(100000.0)
    pizzaCafe.executeOrder(
        setOf(pizzaCafe.order(MenuKind.DISH, "карбонара"))
    )
}

private fun printLine() = print("\n\n---------------------------------------------------------\n\n")