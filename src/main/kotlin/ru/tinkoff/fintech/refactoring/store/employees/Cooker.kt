package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.IngredientMenu
import ru.tinkoff.fintech.refactoring.menu.MenuFactory
import ru.tinkoff.fintech.refactoring.products.Dish
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.Order

class Cooker(
    menuFactory: MenuFactory,
) : CafeWorker<Dish>("Повар", menuFactory) {

    private val ingredientMenu = menuFactory.getMenu("ingredients", IngredientMenu::class.java)!!

    override fun start(container: Order) = cook(container)

    override val patternForOrder: (order: Order) -> Boolean
        get() = { order: Order ->
            order.type == "pizza"
        }

    private fun cook(order: Order) {
        val dish = getFoodByOrder(order)
        val ingredients = dish.description.recipe
        println("[$name] Делаю блюдо : ${dish.description.name}")
        println("[$name] Из ингридиетов:")
        var brewTime = 0

        ingredients.forEach {
            val name = it.key
            val count = it.value
            if (ingredientMenu.getPrice(name) == null)
                error("Неизвестный ингредиент")

            val price = ingredientMenu.getPrice(name)!! * count

            println("[$name] - ${name}: в количестве $count за $price$")
            brewTime += count
        }

        println("[$name] время приготовления $brewTime минут")
        val roundedPrice = "%.2f".format(dish.price)
        println("[$name] в сумме за все $roundedPrice$")
    }
}