package ru.tinkoff.fintech.refactoring

abstract class Ingredient(
    val name: String,
    val price: Double,
    var left: Int
)

class Egg : Ingredient("яйца", 3.48, 300)
class Beckon : Ingredient("бекон", 6.48, 150)
class Dough : Ingredient("тесто", 1.00, 200)
class Tomato : Ingredient("оливки", 1.53, 200)
class Olives : Ingredient("оливки", 1.53, 500)
class Cheese : Ingredient("сыр", 0.98, 300)
class Parmesan : Ingredient("пармезан", 3.98, 300)
class Mushrooms : Ingredient("грибы", 3.34, 250)
class Asparagus : Ingredient("спаржа", 3.34, 100)
class Meat : Ingredient("мясное ассорти", 9.38, 150)
class BeefJerky : Ingredient("вяленая говядина", 12.24, 100)
class Salami : Ingredient("салями", 10.21, 250)
class Grass : Ingredient("зелень", 0.12, 200)


fun calculatePrice(pizza: Pizza): Double {
    var result = 0.00
    for (ingredient in pizza.composition) {
        if ((ingredient.key.left - ingredient.value) < 0) {
            error("Не достаточно ингредиентов!")
        }
        ingredient.key.left -= ingredient.value
        result += ingredient.value * ingredient.key.price
    }
    return result
}
