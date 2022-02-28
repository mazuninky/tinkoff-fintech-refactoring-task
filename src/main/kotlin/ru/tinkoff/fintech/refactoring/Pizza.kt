package ru.tinkoff.fintech.refactoring

abstract class Pizza(
    val name: String,
    val ingredients: List<Pair<String, Int>>
)

class Carbonara : Pizza(
    name = "карбонара",
    ingredients = listOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2)
)

class Marinara : Pizza(
    name = "маринара",
    ingredients = listOf("томат" to 2, "оливки" to 3, "тесто" to 1)
)

class Sardinia : Pizza(
    name = "сардиния",
    ingredients = listOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3)
)

class Valtellina : Pizza(
    name = "вальтеллина",
    ingredients = listOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2)
)

class Krestyanskaya : Pizza(
    name = "крестьянская",
    ingredients = listOf("грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1)
)

class PizzaDao {
    fun getPizzaByName(name: String): Pizza? =
        pizzaStore.firstOrNull { it.name == name }

    companion object {
        private val pizzaStore = listOf(
            Carbonara(),
            Marinara(),
            Sardinia(),
            Valtellina(),
            Krestyanskaya()
        )
    }
}
