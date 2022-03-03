package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val number: Int,
    val pizza: Pizza,
)

data class CoffeeOrder(
    val number: Int,
    val pizza: Coffee,
)

class CoffeeShop {
    private val barista = Barista()
    private val coffeeKinds = mapOf(
        "эспрессо" to Coffee("эспрессо", 5.0, 5),
        "капучино" to Coffee("капучино", 3.48, 6),
    )

    fun getCoffeeKind(name: String): Coffee? {
        return coffeeKinds[name]
    }

    fun orderCoffee(coffee: Coffee, orderNumber: Int): CoffeeOrder {
        return CoffeeOrder(
            number = orderNumber,
            pizza = coffee
        )
    }

    fun executeOrder(coffeeOrder: CoffeeOrder) {
        barista.makeCoffee(coffeeOrder)
    }
}

class PizzaKitchen {
    private val pizzaMaker = PizzaMaker()
    private val ingredientKinds = listOf(
        Ingredient("яйца", 3.48),
        Ingredient("бекон", 6.48),
        Ingredient("тесто", 1.00),
        Ingredient("томат", 1.53),
        Ingredient("оливки", 1.53),
        Ingredient("сыр", 0.98),
        Ingredient("пармезан", 3.98),
        Ingredient("грибы", 3.34),
        Ingredient("спаржа", 3.34),
        Ingredient("мясное ассорти", 9.38),
        Ingredient("зелень", 3.2),
        Ingredient("салями", 20.1),
    )

    private val pizzaRecipes = listOf(
        Pizza(
            "карбонара",
            listOf(
                ingredientKinds[0] to 1,
                ingredientKinds[1] to 2,
                ingredientKinds[2] to 1,
                ingredientKinds[5] to 2
            )
        ),
        Pizza(
            "маринара",
            listOf(
                ingredientKinds[3] to 2,
                ingredientKinds[4] to 3,
                ingredientKinds[2] to 1
            )
        ),
        Pizza(
            "сардиния",
            listOf(
                ingredientKinds[11] to 3,
                ingredientKinds[4] to 1,
                ingredientKinds[2] to 1,
                ingredientKinds[5] to 3
            )
        ),
        Pizza(
            "вальтеллина",
            listOf(
                ingredientKinds[10] to 1,
                ingredientKinds[10] to 1,
                ingredientKinds[2] to 1,
                ingredientKinds[6] to 2
            )
        ),
        Pizza(
            "крестьянская",
            listOf(
                ingredientKinds[7] to 3,
                ingredientKinds[3] to 1,
                ingredientKinds[2] to 1,
                ingredientKinds[8] to 1,
                ingredientKinds[9] to 1
            )
        )
    )

    fun getPizzaKind(name: String): Pizza? {
        return pizzaRecipes.find { it.name == name }
    }

    fun orderPizza(pizza: Pizza, orderNumber: Int): PizzaOrder {
        return PizzaOrder(
            number = orderNumber,
            pizza = pizza
        )
    }

    fun executeOrder(pizzaOrder: PizzaOrder) {
        pizzaMaker.makePizza(pizzaOrder)
    }
}

class PizzaStore {
    var lastOrderNumber = 0

    val pizzaKitchen = PizzaKitchen()
    val coffeeShop = CoffeeShop()

    fun orderPizza(name: String): PizzaOrder {
        val pizza = pizzaKitchen.getPizzaKind(name)
            ?: error("Неизвестный вид пиццы!")
        return pizzaKitchen.orderPizza(pizza, ++lastOrderNumber)
    }

    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = coffeeShop.getCoffeeKind(name)
            ?: error("Неизвестный вид кофе!")
        return coffeeShop.orderCoffee(coffee, ++lastOrderNumber)
    }
}
