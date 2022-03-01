package ru.tinkoff.fintech.refactoring

abstract class Pizza(
    val name: String,
    val ingredients: List<Ingredient>
    ){
    val price: Double = ingredients.sumOf{it.price}
}

class Carbonara : Pizza("карбонара", listOf(Eggs(1), Bacon(2), Dough(1), Cheese(2)))

class Marinara : Pizza("маринара", listOf(Tomato(1), Olives(3), Dough(1)))

class Sardinia : Pizza("сардиния", listOf(Salami(3), Olives(1), Dough(1), Cheese(3)))

class Valtellina : Pizza("вальтеллина", listOf(BeefJerky(1), Greenery(1), Dough(1), Parmesan(2)))

class Peasant : Pizza("крестьянская", listOf(Mushrooms(3), Tomato(1), Dough(1), Asparagus(1), Meet(1)))

