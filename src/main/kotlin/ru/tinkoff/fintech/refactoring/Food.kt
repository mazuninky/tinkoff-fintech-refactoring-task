package ru.tinkoff.fintech.refactoring

abstract class Food(
    val name: String,
    val price: Double
) {

    companion object {
        private val foodStore = listOf(Eggs(), Bacon(), Dough(), Tomato(), Olives(), Cheese(),
            Parmesan(), Mushrooms(), Asparagus(), ColdCuts(), BeefJerky())

        fun getFoodByName(name: String): Food {
            val food = foodStore.find { it.name == name }
            return food ?: UnknownFood()
        }
    }
}


class Eggs: Food("яйца", 3.48)

class Bacon: Food("бекон", 6.48)

class Dough: Food("тесто", 1.00)

class Tomato: Food("томат", 1.53)

class Olives: Food("оливки", 1.53)

class Cheese: Food("сыр", 0.98)

class Parmesan: Food("пармезан", 3.98)

class Mushrooms: Food("грибы", 3.34)

class Asparagus: Food("спаржа",3.34)

class ColdCuts: Food("мясное ассорти", 9.38)

class BeefJerky: Food("вяленая говядина",12.24)

class UnknownFood: Food("unknown food", -1.0)