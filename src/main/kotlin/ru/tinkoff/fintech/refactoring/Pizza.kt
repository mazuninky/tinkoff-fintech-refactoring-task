package ru.tinkoff.fintech.refactoring

interface Pizza {
    val name: String
    val ingredients: List<Pair<String, Int>>
}

class Carbonara : Pizza {
    override val name: String
        get() = "карбонара"
    override val ingredients: List<Pair<String, Int>>
        get() = listOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2)
}

class Marinara : Pizza {
    override val name: String
        get() = "маринара"
    override val ingredients: List<Pair<String, Int>>
        get() = listOf("томат" to 2, "оливки" to 3, "тесто" to 1)
}

class Sardinia : Pizza {
    override val name: String
        get() = "сардиния"
    override val ingredients: List<Pair<String, Int>>
        get() = listOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3)
}

class Valtellina : Pizza {
    override val name: String
        get() = "вальтеллина"
    override val ingredients: List<Pair<String, Int>>
        get() = listOf("вяленая говядина" to 1, "зелень" to 1, "тесто" to 1, "пармезан" to 2)
}

class Krestyanskaya : Pizza {
    override val name: String
        get() = "крестьянская"
    override val ingredients: List<Pair<String, Int>>
        get() = listOf("грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1)
}

class PizzaDao(private val pizzaStore: List<Pizza>) {

    fun getPizzaByName(name: String): Pizza? =
        pizzaStore.firstOrNull { it.name == name }
}
