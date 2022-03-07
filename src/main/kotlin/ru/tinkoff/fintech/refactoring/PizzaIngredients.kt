package ru.tinkoff.fintech.refactoring

// Здесь кажется логичным вариантом было бы использовать map для хранения ингредиентов

object PizzaIngredients {

//    val ingredientsList = mapOf("яйца" to 3.48,
//    "бекон" to 6.48,
//    "тесто" to 1.00,
//    "томат" to 1.53,
//    "оливки" to 1.53,
//    "сыр" to 0.98,
//    "пармезан" to 3.98,
//    "грибы" to 3.34,
//    "спаржа" to 3.34,
//    "мясное ассорти" to 9.38,
//    "вяленая говядина" to 12.24)

    fun getIngredientPrice(ingredientName: String): Double {
        return when (ingredientName) {
            "яйца" -> 3.48
            "бекон" -> 6.48
            "тесто" -> 1.00
            "томат" -> 1.53
            "оливки" -> 1.53
            "сыр" -> 0.98
            "пармезан" -> 3.98
            "грибы" -> 3.34
            "спаржа" -> 3.34
            "мясное ассорти" -> 9.38
            "вяленая говядина" -> 12.24
            else -> error("Неизвестный ингредиент")
        }
    }

    fun getIngredients4Pizza(ingredientName: String): List<Ingredient> {
        return when (ingredientName) {
            "карбонара" -> listOf(
                Ingredient("яйца", 1),
                Ingredient("бекон", 2),
                Ingredient("тесто", 1),
                Ingredient("сыр", 2)
            )
            "крестьянская" -> listOf(
                Ingredient("грибы", 3),
                Ingredient("томат", 1),
                Ingredient("тесто", 1),
                Ingredient("спаржа", 1),
                Ingredient("мясное ассорти", 1)
            )
            "вальтеллина" -> listOf(
                Ingredient("вяленая говядина", 1),
                Ingredient("зелень", 1),
                Ingredient("тесто", 1),
                Ingredient("пармезан", 2)
            )
            "сардиния" -> listOf(
                Ingredient("салями", 3),
                Ingredient("оливки", 1),
                Ingredient("тесто", 1),
                Ingredient("сыр", 3)
            )
            "маринара" -> listOf(
                Ingredient("томат", 2),
                Ingredient("оливки", 3),
                Ingredient("тесто", 1)
            )
            else -> error("Неизвестный ингредиент")
        }
    }

}