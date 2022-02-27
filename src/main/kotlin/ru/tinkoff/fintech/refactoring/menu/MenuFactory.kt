package ru.tinkoff.fintech.refactoring.menu

interface MenuFactory {
    fun <MENU_T : Menu<*>> getMenu(menuKind: MenuKind, clazz: Class<MENU_T>): MENU_T?
    fun getMenu(menuKind: MenuKind): Menu<*>?
}