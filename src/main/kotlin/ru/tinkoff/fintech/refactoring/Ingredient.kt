package ru.tinkoff.fintech.refactoring

data class Ingredient (val name: String, val price: Double)

class IngredientDAO {
    fun getIngredientByName(name: String): Ingredient {
        return when (name) {
            "яйца" -> Ingredient (name, 3.48)
            "бекон" -> Ingredient (name, 6.48)
            "тесто" -> Ingredient (name, 1.00)
            "томат" -> Ingredient (name, 1.53)
            "оливки" -> Ingredient (name, 1.53)
            "сыр" -> Ingredient (name, 0.98)
            "пармезан" -> Ingredient (name, 3.98)
            "грибы" -> Ingredient (name, 3.34)
            "спаржа" -> Ingredient (name, 3.34)
            "мясное ассорти" -> Ingredient (name, 9.38)
            "вяленая говядина" -> Ingredient (name, 12.24)
            else -> error("Неизвестный ингредиент")
        }
    }
}






