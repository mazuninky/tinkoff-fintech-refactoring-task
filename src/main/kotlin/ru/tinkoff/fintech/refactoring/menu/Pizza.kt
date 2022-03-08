package ru.tinkoff.fintech.refactoring.menu


interface PizzaDAO {

    fun getIngredientsOfPizza(name: String): List<Pair<String, Int>>?
    fun getPizzaByName(name: String): Pizza?
}

class PizzaDAOImpl : PizzaDAO {

    private val pizzaStore = listOf(Carbonara(), Marinara(), Sardinia(), Valtellina(), Peasant())

    private val pizzaIngredients = mapOf(
        "карбонара" to listOf(
            "яйца" to 1,
            "бекон" to 2,
            "тесто" to 1,
            "сыр" to 2,
        ),

        "маринара" to listOf(
            "томат" to 2,
            "оливки" to 3,
            "тесто" to 1,
        ),

        "сардиния" to listOf(
            "салями" to 3,
            "оливки" to 1,
            "тесто" to 1,
            "сыр" to 3,
        ),

        "вальтеллина" to listOf(
            "вяленая говядина" to 1,
            "зелень" to 1,
            "тесто" to 1,
            "пармезан" to 2,
        ),

        "крестьянская" to listOf(
            "грибы" to 3,
            "томат" to 1,
            "тесто" to 1,
            "спаржа" to 1,
            "мясное ассорти" to 1,
        )

    )

    override fun getIngredientsOfPizza(name: String): List<Pair<String, Int>>? {
        return pizzaIngredients[name]
    }

    override fun getPizzaByName(name: String): Pizza? {
        return pizzaStore.find { it.name == name }
    }

}

abstract class Pizza(val name: String)


class Carbonara : Pizza("карбонара")

class Marinara : Pizza("маринара")

class Sardinia : Pizza("сардиния")

class Valtellina : Pizza("вальтеллина")

class Peasant : Pizza("крестьянская")
