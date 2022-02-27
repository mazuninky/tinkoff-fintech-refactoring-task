package ru.tinkoff.fintech.refactoring.menu

class MenuFactoryImpl : MenuFactory {
    companion object {
        private val menu: MutableMap<String, Menu<*>> = mutableMapOf()

        init {
            menu["ingredients"] = IngredientMenu()
            menu["coffee"] = CoffeeMenu()
            menu["pizza"] = PizzaMenu()
        }

        internal fun <MENU_T : Menu<*>> getMenu(key: String, clazz: Class<MENU_T>): MENU_T? {
            return menu[key] as? MENU_T
        }

        internal fun getMenu(key: String): Menu<*>? = menu[key]
    }

    override fun <MENU_T : Menu<*>> getMenu(key: String, clazz: Class<MENU_T>): MENU_T? =
        MenuFactoryImpl.getMenu(key, clazz)

    override fun getMenu(key: String): Menu<*>? =
        MenuFactoryImpl.getMenu(key)
}