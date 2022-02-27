package ru.tinkoff.fintech.refactoring

class IngredientsPrice{

    fun getPrice(name: String) = when (name)
    {
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