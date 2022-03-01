package ru.tinkoff.fintech.refactoring

abstract class Ingredient(val name: String, val price: Double, val count: Int = 1)

class Eggs(count: Int = 1) : Ingredient("яйца" , 3.48)

class Bacon(count: Int = 1) : Ingredient("бекон" ,6.48)

class Dough(count: Int = 1) : Ingredient("тесто" ,1.00)

class Tomato(count: Int = 1) : Ingredient("томат" ,1.53)

class Olives(count: Int = 1) : Ingredient("оливки" ,1.53)

class Cheese(count: Int = 1) : Ingredient("сыр" ,0.98)

class Parmesan(count: Int = 1) : Ingredient("пармезан" ,3.98)

class Mushrooms(count: Int = 1) : Ingredient("грибы" ,3.34)

class Asparagus(count: Int = 1) : Ingredient("спаржа" ,3.34)

class Meet(count: Int = 1) : Ingredient("мясное ассорти" ,9.38)

class BeefJerky(count: Int = 1) : Ingredient("вяленая говядина", 12.24)



//Unspecified price
class Greenery(count: Int = 1) : Ingredient("зелень", 0.001)

class Salami(count: Int = 1) : Ingredient("салями", 0.001)

