package ru.tinkoff.fintech.refactoring

interface Pizza : Product {
    fun getIngredient(): List<Ingredient>

}

data class Ingredient(val name : String, val amount : Int)

class PizzaCarbonara() : Pizza {

    override val name: String = "карбонара"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return PizzaIngredients.getIngredients4Pizza("карбонара")
    }
}

class PizzaPeasant() : Pizza {

    override val name: String = "крестьянская"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return PizzaIngredients.getIngredients4Pizza("крестьянская")
    }
}

class PizzaValtellina() : Pizza {

    override val name: String = "вальтеллина"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return PizzaIngredients.getIngredients4Pizza("вальтеллина")
    }
}

class PizzaSardinia() : Pizza {

    override val name: String = "сардиния"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return PizzaIngredients.getIngredients4Pizza("сардиния")
    }
}

class PizzaMarinara() : Pizza {

    override val name: String = "маринара"
    override var price: Double = 0.0

    override fun getIngredient(): List<Ingredient> {
        return PizzaIngredients.getIngredients4Pizza("маринара")
    }
}
