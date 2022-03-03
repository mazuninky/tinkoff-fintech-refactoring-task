package ru.tinkoff.fintech.refactoring.store

import ru.tinkoff.fintech.refactoring.menu.MenuKind
import ru.tinkoff.fintech.refactoring.menu.MenuKind.*
import ru.tinkoff.fintech.refactoring.menu.MenuService
import ru.tinkoff.fintech.refactoring.products.Dish
import ru.tinkoff.fintech.refactoring.products.Ingredient
import ru.tinkoff.fintech.refactoring.products.Product

class PricesService(
    private val pricesRepository: PricesRepository,
    private val menuService: MenuService,
) {
    fun calcPrice(menuKind: MenuKind, product: Product): Double? {
        val menu = menuService.getMenu(menuKind)

        if (menuKind == INGREDIENT || menuKind == COFFEE) {
            val pricesByMenuKind = pricesRepository.getPricesByMenuKind(menuKind)
                ?: throw IllegalArgumentException("Нет цены на этот продукт")

            return pricesByMenuKind[product.name]
                ?: throw IllegalArgumentException("Нет цены на продукт ${product.name}")
        }

        if (menuKind == DISH) {
            product as Dish
            val ingredientsWithAmount = product.recipe.mapValues {
                val ingredient = menuService.forceGetMenu(INGREDIENT).get(it.key) as Ingredient?

                if (ingredient == null)
                    null
                else
                    ingredient to it.value
            }
            if (ingredientsWithAmount.containsValue(null)) return null

            return getDishPriceFromRecipe(
                ingredientsWithAmount.map { it.value!!.first to it.value!!.second }.toMap()
            )
        }

        throw IllegalArgumentException("Невозможно определить цену на продукт ${product.name}")
    }


    private fun getDishPriceFromRecipe(ingredientsWithAmount: Map<Ingredient, Int>): Double? {
        val prices = ingredientsWithAmount.entries.map { (ingredient, amount) ->
            calcPrice(INGREDIENT, ingredient) to amount
        }

        if (prices.any { pair -> pair.first == null })
            return null

        return prices.sumOf { (price, amount) ->
            price!! * amount
        }
    }
}