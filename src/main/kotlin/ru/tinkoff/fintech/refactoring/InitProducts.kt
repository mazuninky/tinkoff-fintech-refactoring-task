package ru.tinkoff.fintech.refactoring

fun initProducts(pizzaStore: PizzaStore) {
    PizzaStore.ingredients.add(setOf(
        Ingredients("яйца", 3.48),
        Ingredients("бекон", 6.48),
        Ingredients("тесто", 1.00),
        Ingredients("томат", 1.53),
        Ingredients("оливки", 1.53),
        Ingredients("сыр", 0.98),
        Ingredients("пармезан", 3.98),
        Ingredients("грибы", 3.34),
        Ingredients("спаржа", 3.34),
        Ingredients("мясное ассорти", 9.38),
        Ingredients("вяленая говядина", 12.24),
        Ingredients("салями", 8.43)
    ))

    pizzaStore.coffeeMenu.add(setOf(
        Coffee("эспрессо", 5.0, 5),
        Coffee("капучино", 3.48, 6)
    ))

    pizzaStore.pizzaMenu.add(setOf(
        Pizza("карбонара", listOf("яйца" to 1, "бекон" to 2, "тесто" to 1, "сыр" to 2)),
        Pizza("маринара", listOf("томат" to 2, "оливки" to 3, "тесто" to 1)),
        Pizza("сардиния", listOf("салями" to 3, "оливки" to 1, "тесто" to 1, "сыр" to 3)) ,
        Pizza("крестьянская", listOf("грибы" to 3, "томат" to 1, "тесто" to 1, "спаржа" to 1, "мясное ассорти" to 1))
    ))
}