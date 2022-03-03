package ru.tinkoff.fintech.refactoring

abstract class Ingredient(val name: String, val price: Double, val count: Int = 1)

/************************************************************************Ingredients with price************************/
class Eggs(count: Int = 1) : Ingredient("яйца", 3.48 * count)

class Bacon(count: Int = 1) : Ingredient("бекон", 6.48 * count)

class Dough(count: Int = 1) : Ingredient("тесто", 1.00 * count)

class Tomato(count: Int = 1) : Ingredient("томат", 1.53 * count)

class Olives(count: Int = 1) : Ingredient("оливки", 1.53 * count)

class Cheese(count: Int = 1) : Ingredient("сыр", 0.98 * count)

class Parmesan(count: Int = 1) : Ingredient("пармезан", 3.98 * count)

class Mushrooms(count: Int = 1) : Ingredient("грибы", 3.34 * count)

class Asparagus(count: Int = 1) : Ingredient("спаржа", 3.34 * count)

class Meet(count: Int = 1) : Ingredient("мясное ассорти", 9.38 * count)

class BeefJerky(count: Int = 1) : Ingredient("вяленая говядина", 12.24 * count)

/******************************************************Unspecified price************************************************/

class Greenery(count: Int = 1) : Ingredient("зелень", 0.001 * count)

class Salami(count: Int = 1) : Ingredient("салями", 0.001 * count)
