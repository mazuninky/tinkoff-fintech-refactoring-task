package ru.tinkoff.fintech.refactoring

data class Pizza(
    override val name: String,
    val ingredients: List<Pair<String, Int>>
) : Product {
    override val price: Double = ingredients.sumOf { PizzaStore.ingredients.getIngredientByName(it.first).price * it.second}
}

class PizzaList: ProductList<Pizza>() {
    fun getPizzaByName(name: String): Pizza {
        return getProductByName(name, "Неизвестный вид пиццы: $name")
    }
}

