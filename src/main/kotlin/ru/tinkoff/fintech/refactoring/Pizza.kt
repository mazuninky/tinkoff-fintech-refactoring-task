package ru.tinkoff.fintech.refactoring

enum class Ingredient(
    val ingredientName: String,
    val price: Double
) {
    EGGS("яйца", 3.48),
    BACON("бекон", 6.48),
    DOUGH("тесто", 1.00),
    TOMATO("томат", 1.53),
    OLIVES("оливки", 1.53),
    CHEESE("сыр", 0.98),
    PARMESAN("пармезан", 3.98),
    MUSHROOMS("грибы", 3.34),
    ASPARAGUS("спаржа", 3.34),
    COLD_CUTS("мясное ассорти", 9.38),
    BEEF_JERKY("вяленая говядина", 12.24),
    SALAMI("салями", 8.33),
    GREENS("зелень", 1.28);
}

data class RecipeStep(val ingredient: Ingredient, val count: Int) {
    val price: Double
        get() = count * ingredient.price
}

class Pizza private constructor(
    name: String,
    val ingredients: List<RecipeStep>
) : Product(name, ingredients.sumOf { it.price }, ingredients.sumOf { it.count }) {
    companion object {
        fun getByName(name: String): Pizza {
            return pizzaStore.find { it.name == name }
                ?: error("Неизвестная пицца: $name")
        }

        private val pizzaStore = listOf(
            Pizza(
                "карбонара", listOf(
                    RecipeStep(Ingredient.EGGS, 1),
                    RecipeStep(Ingredient.BACON, 2),
                    RecipeStep(Ingredient.DOUGH, 1),
                    RecipeStep(Ingredient.CHEESE, 2)
                )
            ),
            Pizza(
                "маринара", listOf(
                    RecipeStep(Ingredient.TOMATO, 2),
                    RecipeStep(Ingredient.OLIVES, 3),
                    RecipeStep(Ingredient.DOUGH, 1)
                )
            ),
            Pizza(
                "сардиния", listOf(
                    RecipeStep(Ingredient.SALAMI, 3),
                    RecipeStep(Ingredient.OLIVES, 1),
                    RecipeStep(Ingredient.DOUGH, 1),
                    RecipeStep(Ingredient.CHEESE, 3)
                )
            ),
            Pizza(
                "вальтеллина", listOf(
                    RecipeStep(Ingredient.BEEF_JERKY, 1),
                    RecipeStep(Ingredient.GREENS, 1),
                    RecipeStep(Ingredient.DOUGH, 1),
                    RecipeStep(Ingredient.PARMESAN, 2)
                )
            ),
            Pizza(
                "крестьянская", listOf(
                    RecipeStep(Ingredient.MUSHROOMS, 3),
                    RecipeStep(Ingredient.TOMATO, 1),
                    RecipeStep(Ingredient.DOUGH, 1),
                    RecipeStep(Ingredient.ASPARAGUS, 1),
                    RecipeStep(Ingredient.COLD_CUTS, 1)
                )
            ),
        )
    }
}