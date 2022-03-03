package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.IngredientMenu
import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.menu.MenuKind.INGREDIENT
import ru.tinkoff.fintech.refactoring.menu.MenuService
import ru.tinkoff.fintech.refactoring.products.Dish
import ru.tinkoff.fintech.refactoring.store.PricesService
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

class Cooker(
    override var menuService: MenuService? = null,
    override var priceService: PricesService? = null,
) : CafeWorker<Dish>("Повар", menuService, priceService) {

    private val ingredientMenu
        get() = menuService?.getMenu(INGREDIENT) as IngredientMenu

    override fun start(container: Order) = cook(container)

    override fun needToProcessOrder(order: Order): Boolean =
        order.type == MenuKind.DISH

    private fun cook(order: Order) {
        val dish = getFoodByOrder(order) ?: error("Невозможно приготовить ${order.name}")
        val dishPrice = calcPrice(order)

        val ingredients = dish.recipe
        println("[$name] Делаю блюдо : ${dish.name}")
        println("[$name] Из ингридиетов:")
        var brewTime = 0

        ingredients.forEach {
            val ingredientName = it.key
            val count = it.value

            val ingredient = ingredientMenu.get(ingredientName) ?: error("Неизвестный ингредиент")

            val ingredientPrice = priceService?.calcPrice(INGREDIENT, ingredient)
                ?: error("Невозможно рассчитать цену ингредиента $ingredientName")

            val price = ingredientPrice * count

            println("[$name] - ${ingredientName}: в количестве $count за $price$")
            brewTime += count
        }

        println("[$name] время приготовления $brewTime минут")
        val roundedPrice = "%.2f".format(dishPrice)
        println("[$name] в сумме за все $roundedPrice$")
    }
}