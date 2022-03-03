package ru.tinkoff.fintech.refactoring.products

abstract class Pizza(
    final override val name: String,
    val ingredientToNumber: Map<Ingredient, Int>
) : Product {
    final override val price = ingredientToNumber.entries.fold(0.0) { acc, pair -> acc + pair.key.price * pair.value }
}

class Carbonara : Pizza("карбонара", mapOf(Eggs() to 1, Bacon() to 2, Dough() to 1, Cheese() to 2))
class Marinara : Pizza("маринара", mapOf(Tomato() to 2, Olives() to 3, Dough() to 1))
class Sardinia : Pizza("сардиния", mapOf(Salami() to 3, Olives() to 1, Dough() to 1, Cheese() to 3))
class Valtellina : Pizza("вальтеллина", mapOf(JerkyBeef() to 1, Greens() to 1, Dough() to 1, Parmesan() to 2))
class Peasant :
    Pizza("крестьянская", mapOf(Mushrooms() to 3, Tomato() to 1, Dough() to 1, Asparagus() to 1, ColdCuts() to 1))