package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.menu.MenuKind.*
import ru.tinkoff.fintech.refactoring.products.Product

class MenuFactoryImpl : MenuFactory {
    companion object {
        private val menu: MutableMap<MenuKind, Menu<out Product<*>>> = mutableMapOf()

        init {
            addMenu(INGREDIENT, IngredientMenu())
            addMenu(COFFEE, CoffeeMenu())
            addMenu(PIZZA, PizzaMenu())
        }

        private fun <PRODUCT_T : Product<*>> addMenu(menuKind: MenuKind, menu: Menu<PRODUCT_T>) {
            if (!menu::class.java.isAssignableFrom(menuKind.menuClazz))
                throw IllegalArgumentException("Тип меню не соответсвует ${menuKind.name}")
            MenuFactoryImpl.menu[menuKind] = menu
        }

        internal fun <MENU_T : Menu<*>> getMenu(menuKind: MenuKind, clazz: Class<MENU_T>): MENU_T? {
            return menu[menuKind] as? MENU_T
        }

        internal fun getMenu(menuKind: MenuKind): Menu<*>? = menu[menuKind]
    }

    override fun <MENU_T : Menu<*>> getMenu(menuKind: MenuKind, clazz: Class<MENU_T>): MENU_T? =
        MenuFactoryImpl.getMenu(menuKind, clazz)

    override fun getMenu(menuKind: MenuKind): Menu<*>? =
        MenuFactoryImpl.getMenu(menuKind)
}