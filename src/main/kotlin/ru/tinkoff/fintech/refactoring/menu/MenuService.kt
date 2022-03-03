package ru.tinkoff.fintech.refactoring.menu

import ru.tinkoff.fintech.refactoring.products.Product

class MenuService(
    private val menuRepository: MenuRepository,
) {
    fun<T: Product> getMenu(menuKind: MenuKind): Menu<T>? {
        return menuRepository.mainMenu[menuKind] as Menu<T>
    }
}