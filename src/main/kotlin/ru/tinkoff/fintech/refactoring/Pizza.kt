package ru.tinkoff.fintech.refactoring

interface Pizza : Product {
    fun getIngredient(): List<Ingredient>

}

data class Ingredient(val name : String, val amount : Int)

class PizzaCarbonara() : Pizza {

    override val name: String = "карбонара"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return listOf(Ingredient("яйца", 1), 
            Ingredient("бекон", 2), 
            Ingredient("тесто", 1), 
            Ingredient("сыр", 2))
    }
}

class PizzaPeasant() : Pizza {

    override val name: String = "крестьянская"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return listOf(Ingredient("грибы" , 3),
            Ingredient("томат", 1),
            Ingredient("тесто", 1),
            Ingredient("спаржа", 1),
            Ingredient("мясное ассорти", 1))
    }
}

class PizzaValtellina() : Pizza {

    override val name: String = "вальтеллина"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return listOf(Ingredient("вяленая говядина", 1),
            Ingredient("зелень", 1),
            Ingredient("тесто", 1),
            Ingredient("пармезан", 2))
    }
}

class PizzaSardinia() : Pizza {

    override val name: String = "сардиния"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return listOf(Ingredient("салями", 3),
            Ingredient("оливки", 1),
            Ingredient("тесто", 1),
            Ingredient("сыр", 3))
    }
}

class PizzaMarinara() : Pizza {

    override val name: String = "маринара"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return listOf(Ingredient("томат", 2),
            Ingredient("оливки", 3),
            Ingredient("тесто", 1))
    }
}
