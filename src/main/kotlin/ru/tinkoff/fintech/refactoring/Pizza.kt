package ru.tinkoff.fintech.refactoring

abstract class Pizza(
    val name: String,
    val ingredients: Map<Ingredient, Int> = emptyMap()
) {

    fun getPrice(): Double {
        var price = 0.0
        ingredients.forEach { (ingredient, count) ->
            price += ingredient.price?.times(count) ?: error("Цена ингредиента ${ingredient.ingredientName} не задана")
        }
        return price
    }

    fun getCookingTime(): Int {
        return ingredients.values.sum()
    }
}

class Carbonara : Pizza(
    "карбонара", mapOf(
        Ingredient.EGG to 1,
        Ingredient.BACON to 2,
        Ingredient.DOUGH to 1,
        Ingredient.CHEESE to 2
    )
)

class Marinara : Pizza(
    "маринара", mapOf(
        Ingredient.TOMATO to 2,
        Ingredient.OLIVE to 3,
        Ingredient.DOUGH to 1
    )
)

class Sardinia : Pizza(
    "сардиния", mapOf(
        Ingredient.SALAMI to 3,
        Ingredient.OLIVE to 1,
        Ingredient.DOUGH to 1,
        Ingredient.CHEESE to 3
    )
)

class Valtellina : Pizza(
    "вальтеллина", mapOf(
        Ingredient.BEEF_JERKY to 1,
        Ingredient.GREENERY to 1,
        Ingredient.DOUGH to 1,
        Ingredient.PARMESAN to 2
    )
)

class Peasant : Pizza(
    "крестьянская", mapOf(
        Ingredient.MUSHROOM to 3,
        Ingredient.TOMATO to 1,
        Ingredient.DOUGH to 1,
        Ingredient.ASPARAGUS to 1,
        Ingredient.COLD_CUTS to 1
    )
)
