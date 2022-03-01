package ru.tinkoff.fintech.refactoring

enum class Ingredient(val value: String, val price: Double, var remaining: Int) {
    EGG("яйца", 3.48, 300),
    BECKON("бекон", 6.48, 150),
    DOUGH("тесто", 1.00, 200),
    TOMATO("оливки", 1.53, 200),
    OLIVES("оливки", 1.53, 500),
    CHEESE("сыр", 0.98, 300),
    PARMESAN("пармезан", 3.98, 300),
    MUSHROOM("грибы", 3.34, 250),
    ASPARAGUS("спаржа", 3.34, 100),
    MEAT("мясное ассорти", 9.38, 150),
    BEEFJERKY("вяленая говядина", 12.24, 100),
    SALAMI("салями", 10.21, 250),
    GRASS("зелень", 0.12, 200)
}



