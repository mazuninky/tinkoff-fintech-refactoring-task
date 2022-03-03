package ru.tinkoff.fintech.refactoring.menu

class MenuService(
    private val menuRepository: MenuRepository,
) {
    fun getMenu(menuKind: MenuKind): Menu<*>? {
        return menuRepository.mainMenu[menuKind]
    }

    fun forceGetMenu(menuKind: MenuKind) = getMenu(menuKind)!!
}