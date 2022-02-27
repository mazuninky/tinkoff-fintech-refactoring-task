package ru.tinkoff.fintech.refactoring.menu

interface ContainsIngredient {

    fun getIngredients(): List<Pair<String, Int>>
}

abstract class Pizza(
    val name: String,
) : ContainsIngredient {

    companion object {

        private val pizzaStore = listOf(Carbonara(), Marinara(), Sardinia(), Valtellina(), Peasant())

        fun getPizzaByName(name: String): Pizza? {

            return pizzaStore.find { it.name == name }
        }
    }
}


class Carbonara : Pizza("карбонара") {

    override fun getIngredients() = listOf(
        "яйца" to 1,
        "бекон" to 2,
        "тесто" to 1,
        "сыр" to 2,
    )
}

class Marinara : Pizza("маринара") {

    override fun getIngredients() = listOf(
        "томат" to 2,
        "оливки" to 3,
        "тесто" to 1,
    )
}

class Sardinia : Pizza("сардиния") {

    override fun getIngredients() = listOf(
        "салями" to 3,
        "оливки" to 1,
        "тесто" to 1,
        "сыр" to 3,
    )
}

class Valtellina : Pizza("вальтеллина") {

    override fun getIngredients() = listOf(
        "вяленая говядина" to 1,
        "зелень" to 1,
        "тесто" to 1,
        "пармезан" to 2,
    )
}

class Peasant : Pizza("крестьянская") {

    override fun getIngredients() = listOf(
        "грибы" to 3,
        "томат" to 1,
        "тесто" to 1,
        "спаржа" to 1,
        "мясное ассорти" to 1,
    )
}
