package ru.tinkoff.fintech.refactoring

enum class Ingredient(val ingredientName: String, val price: Double?) {
    EGG("яйца",3.48),
    BACON("бекон", 6.48),
    DOUGH("тесто", 1.00),
    TOMATO("томат", 1.53),
    OLIVE("оливки", 1.53),
    CHEESE("сыр", 0.98),
    PARMESAN("пармезан", 3.98),
    MUSHROOM("грибы", 3.34),
    ASPARAGUS("спаржа", 3.34),
    COLD_CUTS("мясное ассорти", 9.38),
    BEEF_JERKY("вяленая говядина", 12.24),
    SALAMI("салями", null),
    GREENERY("зелень", null)
}
