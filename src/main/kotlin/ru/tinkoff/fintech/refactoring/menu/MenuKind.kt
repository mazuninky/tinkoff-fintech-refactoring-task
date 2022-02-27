package ru.tinkoff.fintech.refactoring.menu

enum class MenuKind(val menuClazz: Class<out Menu<*>>) {
    PIZZA(PizzaMenu::class.java),
    INGREDIENT(IngredientMenu::class.java),
    COFFEE(CoffeeMenu::class.java)
}