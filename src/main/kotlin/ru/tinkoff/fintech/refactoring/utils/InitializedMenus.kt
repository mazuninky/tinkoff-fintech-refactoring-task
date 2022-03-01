package ru.tinkoff.fintech.refactoring.utils

import ru.tinkoff.fintech.refactoring.menu.*
import ru.tinkoff.fintech.refactoring.products.Coffee
import ru.tinkoff.fintech.refactoring.products.Dish
import ru.tinkoff.fintech.refactoring.products.Ingredient
import ru.tinkoff.fintech.refactoring.products.Product
import java.time.Duration

class InitializedMenus {
    private val ingredientMenu: IngredientMenu
    private val coffeeMenu: CoffeeMenu
    private val pizzaMenu: PizzaMenu
    val mainMenu: Map<MenuKind, Menu<out Product>>

    init {
        ingredientMenu = initIngredientMenu()
        coffeeMenu = initCoffeeMenu()
        pizzaMenu = initPizzaMenu()
        mainMenu = mapOf(
            MenuKind.PIZZA to pizzaMenu,
            MenuKind.INGREDIENT to ingredientMenu,
            MenuKind.COFFEE to coffeeMenu,
        )
    }


    private fun initIngredientMenu(): IngredientMenu {
        val menu: Map<String, Ingredient> = mapOf(
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

        return IngredientMenu(menu)
    }

    private fun initCoffeeMenu(): CoffeeMenu {
        val localMenu = setOf(
            Coffee("эспрессо", Duration.ofMinutes(5), 5.0),
            Coffee("капучино", Duration.ofMinutes(6), 3.48),
        ).associateBy { it.name }
        return CoffeeMenu(localMenu)
    }

    private fun getDishPriceFromRecipe(getIngredient: (String) -> Ingredient?): (Map<String, Int>) -> Double? = {

        try {
            it
                .mapKeys { entry ->
                    getIngredient(entry.key) ?: throw IllegalStateException("Невозможно определить цену ${entry.key} ")
                }
                .entries.fold(0.0) { acc, entry ->
                    val ingredientPrice = entry.key.getPrice().invoke()
                        ?: throw IllegalStateException("Невозможно определить цену ${entry.key.name} ")
                    acc + ingredientPrice * entry.value
                }
        } catch (e: IllegalStateException) {
            null
        }
    }

    private fun initPizzaMenu(): PizzaMenu {
        val menu = mapOf(
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
        ).mapValues {
            val recipe = it.value
            val gettingDishPriceWay: (Map<String, Int>) -> Double? = getDishPriceFromRecipe { key ->
                ingredientMenu.get(key)
            }



            Dish(it.key, recipe) {
                gettingDishPriceWay(recipe)
            }
        }

        return PizzaMenu(menu)
    }
}