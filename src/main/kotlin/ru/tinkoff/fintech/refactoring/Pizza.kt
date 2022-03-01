package ru.tinkoff.fintech.refactoring

data class Pizza(override val name: String, override val price: Double, val ingredients: Map<Ingredient, Int>) :
    Product(name, price)

class PizzaFactory {
    fun getPizzaByName(name: String): Pizza {
        val ingredientFactory = IngredientFactory()
        return when (name) {
            "карбонара" -> {
                val ingredients = mapOf(
                    ingredientFactory.getIngredientByName("яйца") to 1,
                    ingredientFactory.getIngredientByName("бекон") to 2,
                    ingredientFactory.getIngredientByName("тесто") to 1,
                    ingredientFactory.getIngredientByName("сыр") to 2
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            "маринара" -> {
                val ingredients = mapOf(
                    ingredientFactory.getIngredientByName("томат") to 2,
                    ingredientFactory.getIngredientByName("оливки") to 3,
                    ingredientFactory.getIngredientByName("тесто") to 1
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            "сардиния" -> {
                val ingredients = mapOf(
                    ingredientFactory.getIngredientByName("салями") to 3,
                    ingredientFactory.getIngredientByName("оливки") to 1,
                    ingredientFactory.getIngredientByName("тесто") to 1,
                    ingredientFactory.getIngredientByName("сыр") to 3
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            "вальтеллина" -> {
                val ingredients = mapOf(
                    ingredientFactory.getIngredientByName("вяленая говядина") to 1,
                    ingredientFactory.getIngredientByName("зелень") to 1,
                    ingredientFactory.getIngredientByName("тесто") to 1,
                    ingredientFactory.getIngredientByName("пармезан") to 2
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            "крестьянская" -> {
                val ingredients = mapOf(
                    ingredientFactory.getIngredientByName("грибы") to 3,
                    ingredientFactory.getIngredientByName("томат") to 1,
                    ingredientFactory.getIngredientByName("тесто") to 1,
                    ingredientFactory.getIngredientByName("спаржа") to 1,
                    ingredientFactory.getIngredientByName("мясное ассорти") to 1
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            else -> error("Неизвестный вид пиццы")
        }
    }
}
