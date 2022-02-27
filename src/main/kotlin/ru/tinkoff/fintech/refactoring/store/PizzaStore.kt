//package ru.tinkoff.fintech.refactoring.store
//
//import ru.tinkoff.fintech.refactoring.menu.IngredientMenu
//import ru.tinkoff.fintech.refactoring.menu.Menu
//import ru.tinkoff.fintech.refactoring.menu.MenuFactory
//import ru.tinkoff.fintech.refactoring.menu.PizzaMenu
//import ru.tinkoff.fintech.refactoring.products.productsImpl.Pizza
//
//class PizzaStore : Store<Pizza>(
//    initPizzas()
//) {
//    companion object {
//        private fun initPizzas(): Map<String, Pizza> {
//            val pizzaMenu = MenuFactory.getMenu("pizzas", PizzaMenu::class.java)
//            val ingredientStore = MenuFactory.getMenu("ingredients", IngredientMenu::class.java)
//
//            return pizzaMenu.get().mapValues {
//                Pizza(it.key,
//                    it.value.mapKeys { ingredient ->
//                        ingredientStore.get(ingredient.key)
//                    }
//                )
//            }
//        }
//    }
//}