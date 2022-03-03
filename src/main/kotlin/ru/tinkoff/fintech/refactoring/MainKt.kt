package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.menu.MenuRepository
import ru.tinkoff.fintech.refactoring.menu.MenuService
import ru.tinkoff.fintech.refactoring.store.PizzaCafe
import ru.tinkoff.fintech.refactoring.store.PricesRepository
import ru.tinkoff.fintech.refactoring.store.PricesService
import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.Barista
import ru.tinkoff.fintech.refactoring.store.employees.Cleaner
import ru.tinkoff.fintech.refactoring.store.employees.Cooker

fun main() {
    val menuService = MenuService(MenuRepository())
    val priceRepository = PricesRepository()
    val priceService = PricesService(priceRepository, menuService)
    val workers = createWorkers()

    val pizzaCafe = PizzaCafe(menuService, priceService, workers)

    val pizzaz = listOf("карбонара", "сардиния")

    val pizzaOrders = pizzaz.mapNotNull { name ->
        try {
            pizzaCafe.order(MenuKind.DISH, name)
        } catch (ex: IllegalStateException) {
            println(ex.message)
            println()
            null
        }
    }

    val coffees = listOf("эспрессо", "эспрессо".reversed())
    val coffeeOrders = coffees.mapNotNull { name ->
        try {
            pizzaCafe.order(MenuKind.COFFEE, name)
        } catch (ex: IllegalStateException) {
            println(ex.message)
            println()
            null
        }
    }

    val order = setOf(
        pizzaOrders, coffeeOrders
    ).flatten().toSet()

    pizzaCafe.executeOrder(order)

    printLine()

    val ingredientPrices = priceRepository.getPricesByMenuKind(MenuKind.INGREDIENT)!!
    ingredientPrices["яйца"] = 100000.0

    pizzaCafe.executeOrder(
        setOf(pizzaCafe.order(MenuKind.DISH, "карбонара"))
    )
}

private fun printLine() = print("\n\n---------------------------------------------------------\n\n")

private fun createWorkers() =
    mapOf(
        Area.FOOD to setOf(
            Cooker(),
            Barista(),
        ),
        Area.OTHER to setOf(Cleaner())
    )