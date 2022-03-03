package ru.tinkoff.fintech.refactoring

import ru.tinkoff.fintech.refactoring.menu.*
import ru.tinkoff.fintech.refactoring.products.Coffee
import ru.tinkoff.fintech.refactoring.products.Dish
import ru.tinkoff.fintech.refactoring.products.Ingredient
import ru.tinkoff.fintech.refactoring.store.employees.Area
import ru.tinkoff.fintech.refactoring.store.employees.Barista
import ru.tinkoff.fintech.refactoring.store.employees.Cleaner
import ru.tinkoff.fintech.refactoring.store.employees.Cooker
import java.time.Duration

class MainUtilFactory {

    fun createWorkers(mainMenu: Map<MenuKind, Menu<*>>) =
        mapOf(
            Area.FOOD to setOf(
                Cooker(mainMenu),
                Barista(mainMenu),
            ),
            Area.OTHER to setOf(Cleaner())
        )


    fun createIngredientMenu() = IngredientMenu(
        mapOf(
            "яйца" to 3.48,
            "бекон" to 6.48,
            "тесто" to 1.00,
            "томат" to 1.53,
            "оливки" to 1.53,
            "сыр" to 0.98,
            "пармезан" to 3.98,
            "грибы" to 3.34,
            "спаржа" to 3.34,
            "мясное ассорти" to 9.38,
            "вяленая говядина" to 12.24,
        ).mapValues { Ingredient(it.key, it.value) }
    )

    fun createCoffeMenu() = CoffeeMenu(
        setOf(
            Coffee("эспрессо", Duration.ofMinutes(5), 5.0),
            Coffee("капучино", Duration.ofMinutes(6), 3.48),
        ).associateBy { it.name }
    )

    fun createPizzaMenu(ingredientMenu: IngredientMenu) = PizzaMenu(
        mapForPizzaMenuInitializing.mapValues {
            createDishFromItsRecipeAndIngredientMenu(it.key, it.value, ingredientMenu)
        }
    )

    private val mapForPizzaMenuInitializing = mapOf(
        "карбонара" to mapOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2),
        "маринара" to mapOf("томат" to 2, "оливки" to 3, "тесто" to 1),
        "сардиния" to mapOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3),
        "вальтеллина" to mapOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2),
        "крестьянская" to mapOf(
            "грибы" to 3,
            "томат" to 1,
            "тесто" to 1,
            "спаржа" to 1,
            "мясное ассорти" to 1
        ),
    )

    private fun createDishFromItsRecipeAndIngredientMenu(
        name: String,
        recipe: Map<String, Int>,
        ingredientMenu: IngredientMenu
    ) = Dish(name, recipe) {
        val ingredientsWithAmount = recipe.mapValues {
            val ingredient = ingredientMenu.get(it.key)
            if (ingredient == null)
                null
            else
                ingredient to it.value
        }
        if (ingredientsWithAmount.containsValue(null))
            null
        else
            getDishPriceFromRecipe(
                ingredientsWithAmount.map { it.value!!.first to it.value!!.second }.toMap()
            )
    }

    private fun getDishPriceFromRecipe(ingredientsWithAmount: Map<Ingredient, Int>): Double? {
        val prices = ingredientsWithAmount.entries.map { (ingredient, amount) ->
            ingredient.price to amount
        }

        if (prices.any { pair -> pair.first == null })
            return null

        return prices.sumOf { (price, amount) ->
            price!! * amount
        }
    }
}

