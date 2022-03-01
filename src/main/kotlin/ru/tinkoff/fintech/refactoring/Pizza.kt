package ru.tinkoff.fintech.refactoring

data class Pizza(override val name: String, override val price: Double, val ingredients: Map<Ingredient, Int>) :
    Product(name, price)

class PizzaDAO {
    fun getPizzaByName(name: String): Pizza {
        val ingredientDAO = IngredientDAO()
        return when (name) {
            "карбонара" -> {
                val ingredients = mapOf(
                    ingredientDAO.getIngredientByName("яйца") to 1,
                    ingredientDAO.getIngredientByName("бекон") to 2,
                    ingredientDAO.getIngredientByName("тесто") to 1,
                    ingredientDAO.getIngredientByName("сыр") to 2
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            "маринара" -> {
                val ingredients = mapOf(
                    ingredientDAO.getIngredientByName("томат") to 2,
                    ingredientDAO.getIngredientByName("оливки") to 3,
                    ingredientDAO.getIngredientByName("тесто") to 1
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            "сардиния" -> {
                val ingredients = mapOf(
                    ingredientDAO.getIngredientByName("салями") to 3,
                    ingredientDAO.getIngredientByName("оливки") to 1,
                    ingredientDAO.getIngredientByName("тесто") to 1,
                    ingredientDAO.getIngredientByName("сыр") to 3
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            "вальтеллина" -> {
                val ingredients = mapOf(
                    ingredientDAO.getIngredientByName("вяленая говядина") to 1,
                    ingredientDAO.getIngredientByName("зелень") to 1,
                    ingredientDAO.getIngredientByName("тесто") to 1,
                    ingredientDAO.getIngredientByName("пармезан") to 2
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            "крестьянская" -> {
                val ingredients = mapOf(
                    ingredientDAO.getIngredientByName("грибы") to 3,
                    ingredientDAO.getIngredientByName("томат") to 1,
                    ingredientDAO.getIngredientByName("тесто") to 1,
                    ingredientDAO.getIngredientByName("спаржа") to 1,
                    ingredientDAO.getIngredientByName("мясное ассорти") to 1
                )
                val price = ingredients.map { (ingredient, quantity) -> ingredient.price * quantity }.sum()
                Pizza(name, price, ingredients)
            }
            else -> error("Неизвестный вид пиццы")
        }
    }
}
