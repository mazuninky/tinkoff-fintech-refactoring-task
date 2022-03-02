package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.IngredientMenu
import ru.tinkoff.fintech.refactoring.menu.Menu
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.products.Dish
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

class Cooker(
    override val menu: Map<MenuKind, Menu<*>>,
) : CafeWorker<Dish>("Повар", menu) {

    private val ingredientMenu
        get() = menu[MenuKind.INGREDIENT] as IngredientMenu

    override fun start(container: Order) = cook(container)

    override fun needToProcessOrder(order: Order): Boolean =
        order.type == MenuKind.DISH

    private fun cook(order: Order) {
        val dish = getFoodByOrder(order) ?: error("Невозможно приготовить ${order.name}")
        val ingredients = dish.recipe
        println("[$name] Делаю блюдо : ${dish.name}")
        println("[$name] Из ингридиетов:")
        var brewTime = 0

        ingredients.forEach {
            val ingredientName = it.key
            val count = it.value
            if (ingredientMenu.prices[ingredientName] == null)
                error("Неизвестный ингредиент")

            val price = ingredientMenu.prices[ingredientName]!! * count

            println("[$name] - ${ingredientName}: в количестве $count за $price$")
            brewTime += count
        }

        println("[$name] время приготовления $brewTime минут")
        val roundedPrice = "%.2f".format(dish.getPrice().invoke())
        println("[$name] в сумме за все $roundedPrice$")
    }
}