package ru.tinkoff.fintech.refactoring

abstract class Pizza(
    val name: String,
    var composition: Map<Ingredient, Int>
)

class Carbonara : Pizza("карбонара", mapOf(Egg() to 1, Beckon() to 2, Dough() to 1, Cheese() to 2))
class Marinara : Pizza("маринара", mapOf(Tomato() to 2, Olives() to 3, Dough() to 1))
class Sardinya : Pizza("сардиния", mapOf(Salami() to 3, Olives() to 1, Dough() to 1, Cheese() to 3))
class Valtellina : Pizza("вальтеллина", mapOf(BeefJerky() to 1, Grass() to 1, Dough() to 1, Parmesan() to 2))
class Peasant :
    Pizza("крестьянская", mapOf(Mushrooms() to 3, Tomato() to 1, Dough() to 1, Asparagus() to 1, Meat() to 1))

val pizzaType = setOf(Carbonara(), Marinara(), Sardinya(), Valtellina(), Peasant())
fun isPizzaAvailable(name: String): Pizza? {
    return pizzaType.find { it.name == name }
}

