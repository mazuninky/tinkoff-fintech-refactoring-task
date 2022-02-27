package ru.tinkoff.fintech.refactoring.menu

class MenuFactory {
    companion object {
        private val menu: MutableMap<String, Menu<*>> = mutableMapOf()

        init {
            menu["ingredients"] = IngredientMenu()
            menu["coffee"] = CoffeeMenu()
            menu["pizzas"] = PizzaMenu()
        }

        fun <MENU_T : Menu<*>> getMenu(key: String, clazz: Class<MENU_T>): MENU_T {
            return menu[key] as? MENU_T
                ?: throw IllegalArgumentException("Невозможно привести найденное хранилище к данном классу")
        }
    }
}