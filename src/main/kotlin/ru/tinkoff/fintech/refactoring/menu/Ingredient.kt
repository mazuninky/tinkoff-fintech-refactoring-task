package ru.tinkoff.fintech.refactoring.menu

interface IngredientDAO {
    fun getIngredientByName(name: String): Ingredient?
}

class IngredientDAOImpl : IngredientDAO {

    private val ingredientsStore = listOf(
        Egg(), Bacon(), Dough(), Tomato(), Olive(), Cheese(),
        Parmesan(), Mushroom(), Asparagus(), MeatPlatter(), BeefJerky()
    )

    override fun getIngredientByName(name: String): Ingredient? {

        return ingredientsStore.find { it.name == name }
    }

}

abstract class Ingredient(
    val name: String,
    val price: Double
)

class Egg : Ingredient("яйца", 3.48)

class Bacon : Ingredient("бекон", 6.48)

class Dough : Ingredient("тесто", 1.00)

class Tomato : Ingredient("томат", 1.53)

class Olive : Ingredient("оливки", 1.53)

class Cheese : Ingredient("сыр", 0.98)

class Parmesan : Ingredient("пармезан", 3.98)

class Mushroom : Ingredient("грибы", 3.34)

class Asparagus : Ingredient("спаржа", 3.34)

class MeatPlatter : Ingredient("мясное ассорти", 9.38)

class BeefJerky : Ingredient("вяленая говядина", 12.24)