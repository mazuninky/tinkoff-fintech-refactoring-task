package ru.tinkoff.fintech.refactoring.menu

interface MenuFactory {
    fun <MENU_T : Menu<*>> getMenu(key: String, clazz: Class<MENU_T>): MENU_T?
    fun getMenu(key: String): Menu<*>?
}