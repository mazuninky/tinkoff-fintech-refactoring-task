package ru.tinkoff.fintech.refactoring.products

import ru.tinkoff.fintech.refactoring.menu.IngredientMenu
import ru.tinkoff.fintech.refactoring.menu.MenuFactoryImpl
import ru.tinkoff.fintech.refactoring.products.descriptions.DishDescr

class Dish(
    override val description: DishDescr,
) : Product<DishDescr>(description, calcPrice(description)) {

    companion object {
        private fun calcPrice(dishDescr: DishDescr): Double? {
            val ingredients = MenuFactoryImpl.getMenu("ingredients", IngredientMenu::class.java).menu
            val recipe = dishDescr.recipe

            if (!ingredients.keys.containsAll(recipe.keys)) return null

            var price = 0.0

            recipe.forEach {
                val ingredient = ingredients[it.key]!!
                price += ingredient.price * it.value
            }
            return price
        }
    }

    override fun toString(): String {
        return "{ ${description.name} : ${description.recipe} }"
    }
}