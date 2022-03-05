package ru.tinkoff.fintech.refactoring

class Ingredient(name: String, val count: Int) {
    val food: Food

    init {
        food = Food.getFoodByName(name)
    }
}

abstract class Pizza (
    val name: String,
    val ingredients: List<Ingredient>
) {
    val price: Double

    init {
        var sum = 0.0
        this.ingredients.forEach{
            sum += it.food.price * it.count
        }
        price = sum
    }

    companion object {
        private val pizzaStore = listOf(Carbonara(), Marinara(), Sardinia(), Valtellina(), Peasant())

        fun getPizzaByName(name: String): Pizza? {
            return pizzaStore.find { it.name == name }
        }
    }
}

class Carbonara: Pizza("карбонара", listOf(
    Ingredient("яйца", 1),
    Ingredient("бекон", 2),
    Ingredient("тесто", 1),
    Ingredient("сыр", 2),
))

class Marinara: Pizza("маринара", listOf(
    Ingredient("томат", 2),
    Ingredient("оливки", 3),
    Ingredient("тесто", 1)
))

class Sardinia: Pizza("сардиния", listOf(
    Ingredient("салями", 3),
    Ingredient("оливки", 1),
    Ingredient("тесто", 1),
    Ingredient("сыр", 3)
))

class Valtellina: Pizza("вальтеллина", listOf(
    Ingredient("вяленая говядина", 1),
    Ingredient("зелень", 1),
    Ingredient("тесто", 1),
    Ingredient("пармезан", 2)
))

class  Peasant: Pizza("крестьянская", listOf(
    Ingredient("грибы", 3),
    Ingredient("томат", 1),
    Ingredient("тесто", 1),
    Ingredient("спаржа", 1),
    Ingredient("мясное ассорти", 1)
))


