package ru.tinkoff.fintech.refactoring

data class Ingredients(
    override val name: String,
    override val price: Double
) : Product

class IngredientList: ProductList<Ingredients>() {
    fun getIngredientByName(name: String): Ingredients {
        return getProductByName(name, "Неизвестный ингредиент: $name")
    }
}
