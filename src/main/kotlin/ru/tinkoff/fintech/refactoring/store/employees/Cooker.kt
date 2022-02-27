package ru.tinkoff.fintech.refactoring.store.employees

import ru.tinkoff.fintech.refactoring.menu.IngredientMenu
import ru.tinkoff.fintech.refactoring.store.employees.containersForWork.CookerContainer

class Cooker(
    private val ingredientMenu: IngredientMenu
) : CafeWorker<CookerContainer>("Повар") {

    override fun start(container: CookerContainer) = cook(container)

    private fun cook(container: CookerContainer) {
        val dish = container.dish
        val ingredients = dish.description.recipe
        println("[Повар] Делаю блюдо : ${dish.description.name}")
        println("[Повар] Из ингридиетов:")
        var brewTime = 0

        ingredients.forEach {
            val name = it.key
            val count = it.value
            if (ingredientMenu.getPrice(name) == null)
                error("Неизвестный ингредиент")

            val price = ingredientMenu.getPrice(name)!! * count

            println("[Пицца мейкер] - ${name}: в количестве $count за $price$")
            brewTime += count
        }

        println("[Пицца мейкер] время приготовления $brewTime минут")
        val roundedPrice = "%.2f".format(container.dish.price)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")
    }
}